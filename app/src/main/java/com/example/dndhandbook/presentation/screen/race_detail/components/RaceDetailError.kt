package com.example.dndhandbook.presentation.screen.race_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.base_components.BaseErrorMessage

@Composable
fun RaceDetailError(errorMessage: String) {
    BaseErrorMessage(errorMessage)
}

@Preview
@Composable
fun RaceDetailErrorPreview() {
    RaceDetailError(errorMessage = "Default error message")
}