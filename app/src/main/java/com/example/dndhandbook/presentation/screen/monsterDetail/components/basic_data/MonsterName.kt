package com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseText

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