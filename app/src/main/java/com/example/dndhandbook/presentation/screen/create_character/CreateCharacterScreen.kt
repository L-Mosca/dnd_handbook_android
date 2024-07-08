package com.example.dndhandbook.presentation.screen.create_character

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.common.Constants
import com.example.dndhandbook.common.extensions_functions.getCreateCharacterTitle
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.navigation.Screen
import com.example.dndhandbook.presentation.base_components.BaseErrorMessage
import com.example.dndhandbook.presentation.screen.create_character.components.CreateCharacterTitle
import com.example.dndhandbook.presentation.screen.create_character.components.race.RaceDataList

@Composable
fun CreateCharacterScreen(
    navController: NavHostController,
    viewModel: CreateCharacterViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val state = viewModel.state.value

    BackHandler {
        if (state.step == Constants.CC_CHOSE_RACE) navController.popBackStack()
        else viewModel.previewStep()
    }

    with(state) {
        val alignment = if (error.isNotBlank()) Alignment.Center else Alignment.TopCenter

        Scaffold { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(colorResource(id = R.color.black_800)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                CreateCharacterTitle(title = step.getCreateCharacterTitle(context))

                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = alignment,
                ) {
                    if (error.isNotBlank()) BaseErrorMessage(error)

                    HandleCreateCharacterStep(this@with, navController, viewModel)
                }
            }
        }
    }
}

@Composable
fun HandleCreateCharacterStep(
    state: CreateCharacterState,
    navController: NavHostController,
    viewModel: CreateCharacterViewModel
) {
    with(state) {
        if (error.isNotBlank()) return@with
        when (step) {
            Constants.CC_CHOSE_RACE -> RaceList(raceList, navController, viewModel)
            Constants.CC_CHOSE_SUB_RACE -> SubRaceList(subRaceList, navController, viewModel)
        }
    }
}

@Composable
fun RaceList(
    raceList: DefaultList,
    navController: NavHostController,
    viewModel: CreateCharacterViewModel
) {
    RaceDataList(raceList = raceList,
        onItemSelected = { viewModel.nextStep(it) },
        onItemInfoSelected = { raceIndex ->
            navController.navigate(Screen.RaceDetail.route + "/$raceIndex")
        })
}

@Composable
fun SubRaceList(
    raceList: DefaultList,
    navController: NavHostController,
    viewModel: CreateCharacterViewModel
) {
    RaceDataList(
        onItemSelected = { viewModel.nextStep(it) },
        onItemInfoSelected = { raceIndex ->
            navController.navigate(Screen.SubRaceDetail.route + "/$raceIndex")
        },
        raceList = raceList
    )
}

@Preview
@Composable
fun CreateCharacterPreview() {
    CreateCharacterScreen(rememberNavController())
}