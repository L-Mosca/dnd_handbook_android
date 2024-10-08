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
fun ClassDetailProficiencies(proficiencies: List<DefaultObject> = emptyList()) {
    if (proficiencies.isEmpty()) return

    Column {
        Spacer(Modifier.height(30.dp))
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.class_proficiencies),
            titleColor = R.color.gold_700,
            lineColor = R.color.gold_700,
        )
        proficiencies.forEach { BaseText(text = it.name, color = colorResource(R.color.gold_700)) }
    }
}

@Preview
@Composable
fun ClassDetailProficienciesPreview() {
    val mockData = MockData.getClassDetail()
    ClassDetailProficiencies(proficiencies = mockData.proficiencies)
}