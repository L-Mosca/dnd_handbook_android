package com.example.dndhandbook.presentation.screen.subRaceDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultProficiencyObject
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.domain.models.sub_race.toDefaultRaceObject
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterName
import com.example.dndhandbook.presentation.screen.raceDetail.components.RaceDetailBonuses
import com.example.dndhandbook.presentation.screen.raceDetail.components.RaceDetailTraits

@Composable
fun SubRaceDetailData(subRaceData: SubRaceDetail? = SubRaceDetail()) {
    if (subRaceData == null) return

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top
    ) {
        with(subRaceData) {
            val languages =
                languageOptions.from.options.joinToString(separator = ", ") { it.item.name }

            item { MonsterName(name = name) }
            item { Spacer(modifier = Modifier.height(40.dp)) }
            item { BaseText(text = desc, fontSize = 18.sp) }
            item { Spacer(modifier = Modifier.height(30.dp)) }
            item { SubRaceLanguages(languages) }
            item { SubRaceAbilityBonuses(bonuses = abilityBonuses) }
            item { SubRaceTraits(traits = racialTraits) }
            item { SubRaceStartProficiencies(startingProficiencies) }
        }
    }
}

@Composable
fun SubRaceLanguages(languages: String) {
    if (languages.isBlank()) return

    Column {
        MonsterBasicText(
            title = stringResource(id = R.string.languages),
            description = "$languages."
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun SubRaceAbilityBonuses(bonuses: List<AbilityBonus>) {
    if (bonuses.isEmpty()) return

    Column {
        RaceDetailBonuses(bonuses)
        Spacer(modifier = Modifier.height(30.dp))
    }

}

@Composable
fun SubRaceTraits(traits: List<DefaultProficiencyObject>) {
    if (traits.isEmpty()) return

    Column {
        RaceDetailTraits(traits.toDefaultRaceObject())
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview
@Composable
fun SubRaceDetailDataPreview() {
    SubRaceDetailData(subRaceData = SubRaceDetail().getMockData())
}