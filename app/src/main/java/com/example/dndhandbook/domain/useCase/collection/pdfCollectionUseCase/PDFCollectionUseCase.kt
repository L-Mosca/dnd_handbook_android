package com.example.dndhandbook.domain.useCase.collection.pdfCollectionUseCase

import com.example.dndhandbook.domain.helper.pdf.PDFContract
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import java.io.File
import javax.inject.Inject

class PDFCollectionUseCase @Inject constructor(private val pdfContract: PDFContract) {

    fun generatePDF(collection: MonsterCollection): File {
        return pdfContract.generatePDFFile(collection)
    }

    fun showPreview(file: File) {
        pdfContract.showPDFPreview(file)
    }

    fun shareFile(file: File) {
        pdfContract.sharePDFFile(file)
    }
}