package com.example.dndhandbook.presentation.screen.race_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.domain.models.race.RaceDetail

@Composable
fun RaceDetailData(raceDetail: RaceDetail = RaceDetail()) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Preview
@Composable
fun RaceDetailDataPreview() {
    RaceDetailData()
}