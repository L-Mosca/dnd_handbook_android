package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.presentation.ui.theme.GradientShadowColor

@Composable
fun GradientShadow(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush = GradientShadowColor)
    )
}

@Preview
@Composable
fun GradientShadowPreview() {
    Surface(modifier = Modifier.size(200.dp)) {
        GradientShadow()
    }
}