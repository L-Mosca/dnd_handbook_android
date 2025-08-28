package com.moscatech.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.moscatech.dndhandbook.presentation.ui.theme.Gold800
import com.moscatech.dndhandbook.presentation.ui.theme.Gold900

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