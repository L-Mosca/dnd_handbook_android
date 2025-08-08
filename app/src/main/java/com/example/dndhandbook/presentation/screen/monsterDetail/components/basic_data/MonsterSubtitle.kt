package com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Gray400

@Composable
fun MonsterSubtitle(size: String = "", type: String = "", alignment: String = "") {
    if (size.isBlank() && type.isBlank() && alignment.isBlank()) return
    BaseText(
        text = "$size $type, $alignment",
        fontSize = 16.sp,
        color = Gray400,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
fun MonsterSubtitlePreview() {
    MonsterSubtitle(size = "Large", type = "Undead", alignment = "lawful evil")
}