package com.example.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.example.dndhandbook.presentation.ui.theme.Blue800
import com.example.dndhandbook.presentation.ui.theme.Blue900
import com.example.dndhandbook.presentation.ui.theme.Green800

@Composable
fun RaceDetailBonuses(data: List<AbilityBonus> = emptyList()) {
    if (data.isEmpty()) return

    Column {
        MonsterBaseSubtitle(
            title = stringResource(id = R.string.ability_bonuses),
            titleColor = Blue800,
            lineColor = Blue800
        )
        data.forEach { bonus ->
            MonsterBasicText(
                title = bonus.abilityScore.name,
                description = bonus.bonus.toString(),
                titleColor = Blue900,
                descriptionColor = Green800
            )
        }
    }
}

@Preview
@Composable
fun RaceDetailBonusesPreview() {
    RaceDetailBonuses()
}