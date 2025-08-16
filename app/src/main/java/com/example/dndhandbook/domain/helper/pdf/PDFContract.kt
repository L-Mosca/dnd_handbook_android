package com.example.dndhandbook.domain.helper.pdf

import com.example.dndhandbook.domain.models.collection.MonsterCollection
import java.io.File

interface PDFContract {
    fun showPDFPreview(file: File)
    fun sharePDFFile(file: File)
    fun generatePDFFile(collection: MonsterCollection): File
}