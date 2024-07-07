package com.example.dndhandbook.presentation.screen.sub_race_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.domain.models.sub_race.toDefaultRaceObject
import com.example.dndhandbook.presentation.base_components.DndText
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText
import com.example.dndhandbook.presentation.screen.monster_detail.components.basic_data.MonsterName
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailBonuses
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailTraits

@Composable
fun SubRaceDetailData(subRaceData: SubRaceDetail? = SubRaceDetail()) {
    if (subRaceData == null) return

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.Top
    ) {
        with(subRaceData) {
            val languages =
                languageOptions.from.options.joinToString(separator = ", ") { it.item.name }
            MonsterName(name = name)
            Spacer(modifier = Modifier.height(40.dp))
            DndText(text = desc, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(30.dp))
            if (languages.isNotBlank()) {
                Column {
                    MonsterBasicText(
                        title = stringResource(id = R.string.languages),
                        description = "$languages."
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
            if (abilityBonuses.isNotEmpty()) {
                Column {
                    RaceDetailBonuses(abilityBonuses)
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
            if (racialTraits.isNotEmpty()) {
                RaceDetailTraits(racialTraits.toDefaultRaceObject())
                Spacer(modifier = Modifier.height(30.dp))
            }
            SubRaceStartProficiencies(startingProficiencies)
        }
    }
}

@Preview
@Composable
fun SubRaceDetailDataPreview() {
    SubRaceDetailData(subRaceData = SubRaceDetail().getMockData())
}