package com.example.dndhandbook.presentation.screen.home.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.gif.BaseGif

@Composable
fun HomeBestiary(onBestiaryClicked: (() -> Unit)? = null) {
    BaseGif(
        gifRes = R.drawable.gif_error,
        modifier = Modifier.size(200.dp),
        show = true
    )
}

@Preview
@Composable
fun HomeBestiaryPreview() {
    HomeBestiary()
}