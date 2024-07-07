package com.example.dndhandbook.presentation.screen.sub_race_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.sub_race.SubRaceDetail
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailLoading
import com.example.dndhandbook.presentation.screen.sub_race_detail.components.SubRaceDetailData
import com.example.dndhandbook.presentation.screen.sub_race_detail.components.SubRaceDetailError
import com.example.dndhandbook.presentation.screen.sub_race_detail.components.SubRaceDetailLoading

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
                .background(colorResource(id = R.color.black_800)),
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
                .background(colorResource(id = R.color.black_800)),
        ) {
            SubRaceDetailData(SubRaceDetail().getMockData())
        }
    }
}