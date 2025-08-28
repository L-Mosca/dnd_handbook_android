package com.moscatech.dndhandbook.common.extensions_functions

import android.content.Context
import androidx.core.content.ContextCompat
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.Constants
import dagger.hilt.android.qualifiers.ApplicationContext

fun Int.getCreateCharacterTitle(@ApplicationContext context: Context): String {
    return when(this) {
        Constants.CC_CHOSE_RACE -> ContextCompat.getString(context, R.string.races)
        Constants.CC_CHOSE_SUB_RACE -> context.getString(R.string.sub_races)
        Constants.CC_CHOSE_CLASS -> ContextCompat.getString(context, R.string.classes)
        else -> ""
    }
}