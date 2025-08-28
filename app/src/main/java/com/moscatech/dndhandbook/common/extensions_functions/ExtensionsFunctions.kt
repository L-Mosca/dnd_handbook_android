package com.moscatech.dndhandbook.common.extensions_functions

fun String.capitalizeWords(): String {
    return split(" ").joinToString(" ") { word ->
        word.lowercase().replaceFirstChar {
            if (it.isLowerCase()) it.titlecase() else it.toString()
        }
    }
}

fun String.removeUnderscore(): String = split("_").joinToString(" ") { it.capitalizeWords() }
