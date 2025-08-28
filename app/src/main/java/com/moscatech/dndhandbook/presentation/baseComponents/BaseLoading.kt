package com.moscatech.dndhandbook.presentation.baseComponents

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun BaseLoading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier, color = Crimson800)
}

@Preview
@Composable
fun BaseLoadingPreview() {
    BaseLoading()
}