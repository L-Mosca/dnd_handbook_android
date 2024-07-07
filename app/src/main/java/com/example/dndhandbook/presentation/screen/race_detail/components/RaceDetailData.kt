package com.example.dndhandbook.presentation.screen.race_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.race.RaceDetail
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText
import com.example.dndhandbook.presentation.screen.monster_detail.components.basic_data.MonsterName

@Composable
fun RaceDetailData(raceDetail: RaceDetail = RaceDetail()) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp)
    ) {
        with(raceDetail) {
            val size = "$size. $sizeDescription"
            val languages = languages.joinToString(separator = ", .") { it.name }
            val languageDesc = "$languages.\n$languageDescription"
            MonsterName(name = name)
            Spacer(modifier = Modifier.height(40.dp))
            Topic(title = "${stringResource(id = R.string.size)}.", desc = size)
            Topic(title = "${stringResource(id = R.string.age)}.", desc = age)
            Topic(title = "${stringResource(id = R.string.languages)}.", desc = languageDesc)
            Topic(title = stringResource(id = R.string.alignment), desc = alignment)
            Spacer(modifier = Modifier.height(30.dp))
            RaceDetailBonuses(abilityBonuses)
            Spacer(modifier = Modifier.height(30.dp))
            RaceDetailTraits(traits)
        }
    }
}

@Composable
private fun Topic(title: String, desc: String) {
    Column {
        MonsterBasicText(title = title, description = desc)
        Spacer(Modifier.height(14.dp))
    }
}

@Preview
@Composable
fun RaceDetailDataPreview() {
    RaceDetailData()
}