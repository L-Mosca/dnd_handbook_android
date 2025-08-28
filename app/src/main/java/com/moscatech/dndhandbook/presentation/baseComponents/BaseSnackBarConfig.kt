package com.moscatech.dndhandbook.presentation.baseComponents

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson500
import com.moscatech.dndhandbook.presentation.ui.theme.Gray800
import com.moscatech.dndhandbook.presentation.ui.theme.Green600
import com.moscatech.dndhandbook.presentation.ui.theme.Orange500

enum class SnackBarType { SUCCESS, ERROR, INFO, WARNING }

data class BaseSnackBarConfig(
    val message: String,
    val actionLabel: String? = null,
    val duration: SnackbarDuration = SnackbarDuration.Short,
    val type: SnackBarType = SnackBarType.INFO,
)

@Composable
fun SnackBarType.background(): Color {
    return when (this) {
        SnackBarType.ERROR -> Crimson500
        SnackBarType.SUCCESS -> Green600
        SnackBarType.WARNING -> Orange500
        SnackBarType.INFO -> Gray800
    }
}