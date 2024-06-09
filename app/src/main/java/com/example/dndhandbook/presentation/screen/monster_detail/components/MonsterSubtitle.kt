package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.base_components.BaseText

@Composable
fun MonsterSubtitle(size: String, type: String, alignment: String) {
    BaseText(
        text = "$size $type, $alignment",
        fontSize = 14.sp,
        color = colorResource(id = R.color.gray_400),
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun MonsterSubtitlePreview() {
    MonsterSubtitle(size = "Large", type = "Undead", alignment = "lawful evil")
}