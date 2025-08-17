package com.example.dndhandbook.domain.helper.file

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class FileHelper @Inject constructor(
    @ApplicationContext private val context: Context,
) : FileContract {

    override suspend fun saveFile(file: File, uri: Uri) {
        context.contentResolver.openOutputStream(uri)?.use { output ->
            file.inputStream().use { input ->
                input.copyTo(output)
            }
        }
    }
}