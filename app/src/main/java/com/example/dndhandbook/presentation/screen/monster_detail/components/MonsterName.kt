package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.base_components.BaseText

@Composable
fun MonsterName(name: String) {
    if (name.isBlank()) return
    BaseText(
        text = name,
        fontSize = 24.sp,
        color = colorResource(id = R.color.crimson_800),
        fontWeight = FontWeight.W600
    )
}

@Preview
@Composable
fun MonsterNamePreview() {
    MonsterName(name = "Tyrant Beholder")
}