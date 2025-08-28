package com.moscatech.dndhandbook.domain.helper.pdf

import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import java.io.File

interface PDFContract {
    fun showPDFPreview(file: File)
    fun sharePDFFile(file: File)
    fun generatePDFFile(collection: MonsterCollection): File
}