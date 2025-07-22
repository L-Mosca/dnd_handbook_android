package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun BaseLoading() {
    CircularProgressIndicator(color = Crimson800)
}

@Preview
@Composable
fun BaseLoadingPreview() {
    BaseLoading()
}