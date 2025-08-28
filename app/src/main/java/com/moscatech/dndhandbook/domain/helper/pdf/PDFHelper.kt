package com.moscatech.dndhandbook.domain.helper.pdf

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import com.moscatech.dndhandbook.BuildConfig
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.utils.createDeepLink
import com.moscatech.dndhandbook.utils.fillPageBackground
import com.moscatech.dndhandbook.utils.insertCollectionName
import com.moscatech.dndhandbook.utils.insertMonsterName
import com.moscatech.dndhandbook.utils.insertPageNumber
import com.moscatech.dndhandbook.utils.insertTitle
import com.tom_roush.pdfbox.android.PDFBoxResourceLoader
import com.tom_roush.pdfbox.pdmodel.PDDocument
import com.tom_roush.pdfbox.pdmodel.PDPage
import com.tom_roush.pdfbox.pdmodel.PDPageContentStream
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject


class PDFHelper @Inject constructor(
    @ApplicationContext private val context: Context
) : PDFContract {

    companion object {
        // Page number values
        private const val PAGE_NUMBER_X = 550f
        private const val PAGE_NUMBER_Y = 800f

        // Page title values
        private const val X = 50f
        private const val TITLE_Y = 770f

        // Collection name values
        private const val COLLECTION_NAME_Y = 720f

        // Monster list values
        private const val MONSTER_MARGIN = 45f
        private const val MONSTER_INITIAL_Y = 640f
        private const val LINK_Y_CORRECTION = 6f
        private const val LETTER_SPACE = 14.9f
        private const val MONSTER_NAME_HEIGHT = 26f

        private const val MONSTERS_ON_FIRST_PAGE = 14
        private const val MONSTERS_TO_OTHER_PAGES = 17

        // File constants
        const val APPLICATION_PDF = "application/pdf"
        private const val FILE_PROVIDER = "fileprovider"
        const val PDF_EXTENSION = "pdf"
    }

    override fun showPDFPreview(file: File) {
        val uri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.$FILE_PROVIDER",
            file
        )

        val viewIntent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, APPLICATION_PDF)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        context.startActivity(viewIntent)
    }

    override fun sharePDFFile(file: File) {
        val uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.$FILE_PROVIDER",
            file
        )

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = APPLICATION_PDF
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        context.startActivity(
            Intent.createChooser(shareIntent, context.getString(R.string.share_collection))
                .apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
        )
    }

    override fun generatePDFFile(collection: MonsterCollection): File {
        PDFBoxResourceLoader.init(context)
        val file = File(context.cacheDir, "${collection.name}.$PDF_EXTENSION")

        PDDocument().use { document ->

            // First page has header and 14 monsters
            // Second or higher pages contains 17 monsters each
            val allMonsters = collection.monsterList ?: emptyList()

            val firstPageList = allMonsters.take(MONSTERS_ON_FIRST_PAGE)
            if (firstPageList.isNotEmpty()) document.addFirstPage(collection.name, firstPageList)

            val remainingMonsters = allMonsters.drop(MONSTERS_ON_FIRST_PAGE)

            if (remainingMonsters.isNotEmpty()) {
                val otherPageChunks = remainingMonsters.chunked(MONSTERS_TO_OTHER_PAGES)
                document.addOtherPages(otherPageChunks)
            }

            document.save(file)
        }
        return file
    }

    private fun PDDocument.addFirstPage(collectionName: String, list: List<DefaultObject>) {
        val page = PDPage(PDRectangle.A4)
        addPage(page)

        PDPageContentStream(this, page).use { contentStream ->
            contentStream.fillPageBackground(page)
            contentStream.insertPageNumber(PAGE_NUMBER_X, PAGE_NUMBER_Y, 1)
            contentStream.addHeader(collectionName)
            contentStream.insertMonsterNames(list, MONSTER_INITIAL_Y, page)
        }
    }

    private fun PDDocument.addOtherPages(list: List<List<DefaultObject>>) {
        list.forEachIndexed { chunkIndex, monsterPageList ->
            val pageNumber = chunkIndex + 2
            val page = PDPage(PDRectangle.A4)
            addPage(page)

            PDPageContentStream(this, page).use { contentStream ->
                contentStream.fillPageBackground(page)
                contentStream.insertPageNumber(PAGE_NUMBER_X, PAGE_NUMBER_Y, pageNumber)
                contentStream.insertMonsterNames(monsterPageList, TITLE_Y, page)
            }
        }
    }

    private fun PDPageContentStream.insertMonsterNames(
        list: List<DefaultObject>,
        y: Float,
        page: PDPage,
    ) {
        var initialY = y
        list.forEachIndexed { index, monster ->
            if (index != 0) initialY -= MONSTER_MARGIN
            insertMonsterName(X, initialY, monster.name)
            val link = buildDeepLink(initialY, monster.name, monster.index)
            page.annotations.add(link)
        }
    }

    /**
     * Add a clickable rectangle to cover monster name.
     *
     * @return Deep link to be added as page annotation
     */
    private fun buildDeepLink(
        y: Float,
        monsterName: String,
        monsterIndex: String
    ): PDAnnotationLink {
        return createDeepLink(
            x = X,
            y = getLinkYPosition(y),
            width = getLinkWidth(monsterName),
            height = MONSTER_NAME_HEIGHT,
            deepLink = "${BuildConfig.BASE_DEEP_LINK}/$monsterIndex",
        )
    }

    /**
     * Insert app name and collection name at the top of page
     */
    private fun PDPageContentStream.addHeader(collectionName: String) {
        insertTitle(
            x = X,
            y = TITLE_Y,
            title = context.getString(R.string.app_name),
        )
        insertCollectionName(
            x = X,
            y = COLLECTION_NAME_Y,
            name = collectionName,
        )
    }

    /**
     * @return Correct Y axe value to monster name link
     */
    private fun getLinkYPosition(initialY: Float): Float = initialY - LINK_Y_CORRECTION

    /**
     * @return Calculate correct width value to link cover all monster name
     */
    private fun getLinkWidth(monsterName: String): Float = monsterName.length * LETTER_SPACE
}