package com.example.dndhandbook.presentation.screen.class_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.presentation.base_components.BaseLoading

@Composable
fun ClassDetailLoading() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        BaseLoading()
    }
}

@Preview
@Composable
fun ClassDetailLoadingPreview() {
    ClassDetailLoading()
}