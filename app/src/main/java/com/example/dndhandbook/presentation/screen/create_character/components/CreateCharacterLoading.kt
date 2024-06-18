package com.example.dndhandbook.presentation.screen.create_character.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R

@Composable
fun CreateCharacterLoading () {
    CircularProgressIndicator(color = colorResource(id = R.color.crimson_800))
}


@Preview
@Composable
fun CreateCharacterPreview() {
    CreateCharacterLoading()
}