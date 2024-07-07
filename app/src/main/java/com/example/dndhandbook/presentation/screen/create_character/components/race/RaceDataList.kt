package com.example.dndhandbook.presentation.screen.create_character.components.race

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.domain.models.race.RaceBasicData
import com.example.dndhandbook.domain.models.race.RaceDetail
import com.example.dndhandbook.domain.models.race.RaceList

@Composable
fun RaceDataList(
    raceList: RaceList = RaceList(),
    onItemSelected: ((RaceBasicData) -> Unit),
    onItemInfoSelected: ((String) -> Unit)
) {
    Column {
        raceList.results.forEachIndexed { index, raceBasicData ->
            RaceItem(
                onItemSelected = { onItemSelected.invoke(raceBasicData) },
                raceData = raceBasicData,
                index = index,
                onItemInfoSelected = { onItemInfoSelected(it) })
        }
    }
}

@Preview
@Composable
fun RaceDataListPreview() {
    RaceDataList(onItemSelected = {}, onItemInfoSelected = {})
}