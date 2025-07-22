package com.example.dndhandbook.presentation.screen.subRaceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun SubRaceStartProficiencies(data: List<DefaultObject> = emptyList()) {
    if (data.isEmpty()) return

    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.start_proficiencies),
            titleColor = R.color.green_800,
            lineColor = R.color.green_800
        )
        data.forEach { trait ->
            MonsterBasicText(title = trait.name, description = "", titleColor = R.color.green_900)
        }
    }
}

@Preview
@Composable
fun SubRaceStartProficienciesPreview() {
    SubRaceStartProficiencies()
}