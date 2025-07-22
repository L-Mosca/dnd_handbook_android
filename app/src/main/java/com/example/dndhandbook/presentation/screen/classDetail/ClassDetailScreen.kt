package com.example.dndhandbook.presentation.screen.classDetail

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
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.presentation.screen.classDetail.components.ClassDetailData
import com.example.dndhandbook.presentation.screen.classDetail.components.ClassDetailError
import com.example.dndhandbook.presentation.screen.classDetail.components.ClassDetailLoading
import com.example.dndhandbook.presentation.screen.raceDetail.components.RaceDetailLoading
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun ClassDetailScreen(
    navController: NavHostController,
    viewModel: ClassDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    with(state) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Black800),
            ) {
                when {
                    isLoading -> ClassDetailLoading()
                    error.isNotBlank() -> ClassDetailError(error)
                    classDetail != null -> ClassDetailData(classDetail)
                    else -> RaceDetailLoading()
                }
            }
        }
    }
}


@Preview
@Composable
fun ClassDetailScreenPreview() {
    ClassDetailScreen(rememberNavController())
}