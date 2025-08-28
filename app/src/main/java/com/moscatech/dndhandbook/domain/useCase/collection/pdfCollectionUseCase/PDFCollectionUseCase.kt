package com.moscatech.dndhandbook.domain.useCase.collection.pdfCollectionUseCase

import com.moscatech.dndhandbook.domain.helper.pdf.PDFContract
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import java.io.File
import javax.inject.Inject

class PDFCollectionUseCase @Inject constructor(private val pdfContract: PDFContract) {

    fun generatePDF(collection: MonsterCollection): File {
        return pdfContract.generatePDFFile(collection)
    }

    fun showPreview(file: File) {
        pdfContract.showPDFPreview(file)
    }

    fun showPreview(collection: MonsterCollection) {
        pdfContract.showPDFPreview(generatePDF(collection))
    }

    fun shareFile(file: File) {
        pdfContract.sharePDFFile(file)
    }

    fun shareFile(collection: MonsterCollection) {
        pdfContract.sharePDFFile(generatePDF(collection))
    }
}