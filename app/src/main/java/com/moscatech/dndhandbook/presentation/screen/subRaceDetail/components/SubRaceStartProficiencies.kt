package com.moscatech.dndhandbook.presentation.screen.subRaceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.moscatech.dndhandbook.presentation.ui.theme.Green800
import com.moscatech.dndhandbook.presentation.ui.theme.Green900

@Composable
fun SubRaceStartProficiencies(data: List<DefaultObject> = emptyList()) {
    if (data.isEmpty()) return

    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.start_proficiencies),
            titleColor = Green800,
            lineColor = Green800
        )
        data.forEach { trait ->
            MonsterBasicText(title = trait.name, description = "", titleColor = Green900)
        }
    }
}

@Preview
@Composable
fun SubRaceStartProficienciesPreview() {
    SubRaceStartProficiencies()
}