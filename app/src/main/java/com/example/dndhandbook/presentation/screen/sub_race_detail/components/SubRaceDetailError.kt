package com.example.dndhandbook.presentation.screen.sub_race_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.base_components.BaseErrorMessage

@Composable
fun SubRaceDetailError(errorMessage: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        BaseErrorMessage(errorMessage)
    }
}

@Preview
@Composable
fun SubRaceDetailErrorPreview() {
    SubRaceDetailError("Default Error Message")
}