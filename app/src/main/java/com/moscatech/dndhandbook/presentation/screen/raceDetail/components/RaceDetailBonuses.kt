package com.moscatech.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.race.AbilityBonus
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBaseSubtitle
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.moscatech.dndhandbook.presentation.ui.theme.Blue800
import com.moscatech.dndhandbook.presentation.ui.theme.Blue900
import com.moscatech.dndhandbook.presentation.ui.theme.Green800

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