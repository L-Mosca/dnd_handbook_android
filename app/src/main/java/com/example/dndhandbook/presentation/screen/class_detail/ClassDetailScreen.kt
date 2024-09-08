package com.example.dndhandbook.presentation.screen.class_detail

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
import com.example.dndhandbook.presentation.screen.class_detail.components.ClassDetailData
import com.example.dndhandbook.presentation.screen.class_detail.components.ClassDetailError
import com.example.dndhandbook.presentation.screen.class_detail.components.ClassDetailLoading
import com.example.dndhandbook.presentation.screen.race_detail.components.RaceDetailLoading

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
                    .background(colorResource(id = R.color.black_800)),
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