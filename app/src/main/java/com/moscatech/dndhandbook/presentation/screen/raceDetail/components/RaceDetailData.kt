package com.moscatech.dndhandbook.presentation.screen.raceDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.race.RaceDetail
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterName

@Composable
fun RaceDetailData(raceDetail: RaceDetail = RaceDetail()) {
    LazyColumn(
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
            item { MonsterName(name = name) }
            item { Spacer(modifier = Modifier.height(40.dp)) }
            item { Topic(title = "${stringResource(id = R.string.size)}.", desc = size) }
            item { Topic(title = "${stringResource(id = R.string.age)}.", desc = age) }
            item {
                Topic(
                    title = "${stringResource(id = R.string.languages)}.",
                    desc = languageDesc
                )
            }
            item { Topic(title = stringResource(id = R.string.alignment), desc = alignment) }
            item { Spacer(modifier = Modifier.height(30.dp)) }
            item { RaceDetailBonuses(abilityBonuses) }
            item { Spacer(modifier = Modifier.height(30.dp)) }
            item { RaceDetailTraits(traits) }
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