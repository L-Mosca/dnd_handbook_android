package com.example.dndhandbook.presentation.screen.subRaceDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.presentation.screen.raceDetail.components.RaceDetailLoading
import com.example.dndhandbook.presentation.screen.subRaceDetail.components.SubRaceDetailData
import com.example.dndhandbook.presentation.screen.subRaceDetail.components.SubRaceDetailError
import com.example.dndhandbook.presentation.screen.subRaceDetail.components.SubRaceDetailLoading
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun SubRaceDetailScreen(
    navController: NavHostController,
    viewModel: SubRaceDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Black800)
        ) {
            when {
                state.isLoading -> SubRaceDetailLoading()
                state.error.isNotBlank() -> SubRaceDetailError(state.error)
                state.subRaceDetail != null -> SubRaceDetailData(state.subRaceDetail)
                else -> RaceDetailLoading()
            }
        }
    }
}

@Preview
@Composable
fun SubRaceDetailScreenPreview() {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Black800),
        ) {
            SubRaceDetailData(SubRaceDetail().getMockData())
        }
    }
}