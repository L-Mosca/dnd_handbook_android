package com.example.dndhandbook.common.extensions_functions

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.dndhandbook.R
import com.example.dndhandbook.common.Constants
import dagger.hilt.android.qualifiers.ApplicationContext

fun Int.getCreateCharacterTitle(@ApplicationContext context: Context): String {
    return when(this) {
        Constants.CC_CHOSE_RACE -> ContextCompat.getString(context, R.string.races)
        Constants.CC_CHOSE_CLASS -> ContextCompat.getString(context, R.string.classes)
        else -> ""
    }
}