package com.moscatech.dndhandbook.domain.helper.file

import android.net.Uri
import java.io.File

interface FileContract {
    suspend fun saveFile(file: File, uri: Uri)
}