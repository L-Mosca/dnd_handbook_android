package com.example.dndhandbook.presentation.screen.create_character.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.base_components.BaseErrorMessage

@Composable
fun CreateCharacterError(errorMessage: String) {
    BaseErrorMessage(errorMessage)
}

@Preview
@Composable
fun CreateCharacterErrorPreview() {
    CreateCharacterError(errorMessage = "Default Error Message")
}