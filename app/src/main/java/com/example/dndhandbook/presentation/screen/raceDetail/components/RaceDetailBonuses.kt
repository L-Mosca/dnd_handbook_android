package com.example.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun RaceDetailBonuses(data: List<AbilityBonus> = emptyList()) {
    if (data.isEmpty()) return

    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.ability_bonuses),
            titleColor = R.color.blue_800,
            lineColor = R.color.blue_800
        )
        data.forEach { bonus ->
            MonsterBasicText(
                title = bonus.abilityScore.name,
                description = bonus.bonus.toString(),
                titleColor = R.color.blue_900,
                descriptionColor = R.color.green_800
            )
        }
    }
}

@Preview
@Composable
fun RaceDetailBonusesPreview() {
    RaceDetailBonuses()
}