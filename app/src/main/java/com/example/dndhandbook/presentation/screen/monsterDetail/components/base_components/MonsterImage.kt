package com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.presentation.baseComponents.BaseRemoteImage

@Composable
fun MonsterImage(modifier: Modifier = Modifier, url: String? = null) {
    url?.let { imageUrl ->
        BaseRemoteImage(
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize().padding(bottom = 10.dp),
            imageUrl = imageUrl,
            shape = RoundedCornerShape(16.dp),
        )
    }
}

@Preview
@Composable
fun MonsterImagePreview() {
    MonsterImage()
}