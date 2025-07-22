package com.example.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.example.dndhandbook.presentation.ui.theme.Gold800
import com.example.dndhandbook.presentation.ui.theme.Gold900

@Composable
fun RaceDetailTraits(data: List<DefaultObject> = emptyList()) {
    if (data.isEmpty()) return

    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.traits),
            titleColor = Gold800,
            lineColor = Gold800
        )
        data.forEach { trait ->
            MonsterBasicText(title = trait.name, description = "", titleColor = Gold900)
        }
    }
}

@Preview
@Composable
fun RaceDetailTraitsPreview() {
    RaceDetailTraits()
}