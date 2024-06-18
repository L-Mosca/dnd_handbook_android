package com.example.dndhandbook.presentation.screen.create_character.components.race

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.domain.models.race.RaceList

@Composable
fun RaceDataList(raceList: RaceList = RaceList()) {
    Column {
        raceList.results.forEachIndexed { index, raceBasicData ->
            RaceItem(onItemSelected = {}, raceData = raceBasicData, index = index)
        }
    }
}

@Preview
@Composable
fun RaceDataListPreview() {
    RaceDataList()
}