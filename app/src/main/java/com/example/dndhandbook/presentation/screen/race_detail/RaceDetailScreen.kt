package com.example.dndhandbook.presentation.screen.race_detail

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
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailData
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailError
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailLoading

@Composable
fun RaceDetailScreen(
    navController: NavHostController, viewModel: RaceDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    with(state) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(colorResource(id = R.color.black_800)),
            ) {
                when {
                    isLoading -> RaceDetailLoading()
                    error.isNotBlank() -> RaceDetailError(error)
                    raceDetail != null -> RaceDetailData(raceDetail)
                    else -> RaceDetailLoading()
                }
            }
        }
    }
}

@Preview
@Composable
fun RaceDetailScreenPreview() {
    RaceDetailScreen(navController = rememberNavController())
}