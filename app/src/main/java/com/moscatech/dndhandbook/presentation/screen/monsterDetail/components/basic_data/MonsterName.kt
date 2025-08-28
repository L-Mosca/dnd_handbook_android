package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.basic_data

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800

@Composable
fun MonsterName(name: String) {
    if (name.isBlank()) return
    BaseText(
        text = name,
        fontSize = 24.sp,
        color = Crimson800,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
fun MonsterNamePreview() {
    MonsterName(name = "Tyrant Beholder")
}