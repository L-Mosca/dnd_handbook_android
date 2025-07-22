package com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.presentation.baseComponents.BaseRemoteImage

@Composable
fun MonsterImage(url: String? = null) {

    url?.let { imageUrl ->
        BaseRemoteImage(
            imageUrl = imageUrl,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, bottom = 20.dp)
        )
    }
}

@Preview
@Composable
fun MonsterImagePreview() {
    MonsterImage()
}