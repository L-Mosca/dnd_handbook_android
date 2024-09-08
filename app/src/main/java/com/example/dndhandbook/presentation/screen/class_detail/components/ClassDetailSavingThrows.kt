package com.example.dndhandbook.presentation.screen.class_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.common.util.MockData
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBaseSubtitle

@Composable
fun ClassDetailSavingThrows(savingThrows: List<DefaultObject> = emptyList()) {
    if (savingThrows.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.class_proficiencies),
            titleColor = R.color.green_800,
            lineColor = R.color.green_800,
        )
        savingThrows.forEach { BaseText(text = it.name, color = colorResource(R.color.green_800)) }
    }
}

@Preview
@Composable
fun ClassDetailSavingThrowsPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailSavingThrows(savingThrows = mockData.savingThrows)
}