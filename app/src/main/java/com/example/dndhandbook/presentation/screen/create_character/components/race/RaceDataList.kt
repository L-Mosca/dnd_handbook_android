package com.example.dndhandbook.presentation.screen.create_character.components.race

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.models.base.DefaultObject

@Composable
fun RaceDataList(
    raceList: DefaultList = DefaultList(),
    onItemSelected: ((DefaultObject) -> Unit),
    onItemInfoSelected: ((String) -> Unit)
) {
    LazyColumn {
        raceList.results.forEachIndexed { index, raceBasicData ->
            item {
                RaceItem(
                    onItemSelected = { onItemSelected.invoke(raceBasicData) },
                    raceData = raceBasicData,
                    index = index,
                    onItemInfoSelected = { onItemInfoSelected(it) })
            }
        }
    }
}

@Preview
@Composable
fun RaceDataListPreview() {
    RaceDataList(onItemSelected = {}, onItemInfoSelected = {})
}