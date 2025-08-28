package com.moscatech.dndhandbook.utils

import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.presentation.ui.theme.Blue800
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.presentation.ui.theme.Gold700
import com.moscatech.dndhandbook.presentation.ui.theme.Gray100
import com.tom_roush.pdfbox.pdmodel.PDPage
import com.tom_roush.pdfbox.pdmodel.PDPageContentStream
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle
import com.tom_roush.pdfbox.pdmodel.font.PDType1Font
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDActionURI
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink

fun PDPageContentStream.insertPageNumber(x: Float, y: Float, pageNumber: Int) {
    val font = PDType1Font.TIMES_BOLD
    val fontSize = 24f
    val fontColor = Gray100

    setNonStrokingColor(fontColor.red, fontColor.green, fontColor.blue)
    beginText()
    setFont(font, fontSize)
    newLineAtOffset(x, y)
    showText(pageNumber.toString())
    endText()
}

fun PDPageContentStream.insertTitle(x: Float, y: Float, title: String) {
    val font = PDType1Font.TIMES_ROMAN
    val fontSize = 36f
    val fontColor = Crimson800

    setNonStrokingColor(fontColor.red, fontColor.green, fontColor.blue)
    beginText()
    setFont(font, fontSize)
    newLineAtOffset(x, y)
    showText(title)
    endText()
}

fun PDPageContentStream.insertCollectionName(x: Float, y: Float, name: String) {
    val font = PDType1Font.TIMES_ROMAN
    val fontSize = 34f
    val fontColor = Gold700

    setNonStrokingColor(fontColor.red, fontColor.green, fontColor.blue)
    beginText()
    setFont(font, fontSize)
    newLineAtOffset(x, y)
    showText(name)
    endText()
}

fun PDPageContentStream.insertMonsterName(x: Float, y: Float, name: String) {

    val font = PDType1Font.TIMES_ROMAN
    val fontSize = 26f
    val fontColor = Blue800

    setNonStrokingColor(fontColor.red, fontColor.green, fontColor.blue)
    beginText()
    setFont(font, fontSize)
    newLineAtOffset(x, y)
    showText(" - $name")
    endText()
}

fun createDeepLink(
    x: Float,
    y: Float,
    width: Float,
    height: Float,
    deepLink: String
): PDAnnotationLink {
    val link = PDAnnotationLink()
    val rect = PDRectangle(x, y, width, height)
    link.rectangle = rect

    val action = PDActionURI()
    action.uri = deepLink
    link.action = action
    return link
}

fun PDPageContentStream.fillPageBackground(page: PDPage) {
    setNonStrokingColor(Black800.red, Black800.green, Black800.blue)
    addRect(0f, 0f, page.mediaBox.width, page.mediaBox.height)
    fill()
}