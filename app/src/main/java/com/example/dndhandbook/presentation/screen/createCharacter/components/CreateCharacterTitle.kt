package com.example.dndhandbook.presentation.screen.createCharacter.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun CreateCharacterTitle(title: String = "") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        BaseText(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.W600,
            color = Crimson800,
        )
    }
}

@Preview
@Composable
fun CreateCharacterTitlePreview() {
    CreateCharacterTitle(title = "Races")
}