package com.example.dndhandbook.presentation.screen.createCharacter.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.baseComponents.BaseErrorMessage

@Composable
fun CreateCharacterError(errorMessage: String) {
    BaseErrorMessage(errorMessage)
}

@Preview
@Composable
fun CreateCharacterErrorPreview() {
    CreateCharacterError(errorMessage = "Default Error Message")
}