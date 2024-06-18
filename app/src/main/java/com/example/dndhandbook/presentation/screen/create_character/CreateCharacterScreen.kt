package com.example.dndhandbook.presentation.screen.create_character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.example.dndhandbook.presentation.screen.create_character.components.CreateCharacterLoading
import com.example.dndhandbook.presentation.screen.create_character.components.CreateCharacterTitle
import com.example.dndhandbook.presentation.screen.create_character.components.race.RaceDataList

@Composable
fun CreateCharacterScreen(
    navController: NavHostController,
    viewModel: CreateCharacterViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val state = viewModel.state.value

    Scaffold { innerPadding ->

        if (state.isLoading) CreateCharacterLoading()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(colorResource(id = R.color.black_800)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CreateCharacterTitle(title = state.step.getCreateCharacterTitle(context))
            if (state.step == Constants.CC_CHOSE_RACE) RaceDataList(raceList = state.raceList)
        }
    }
}

@Preview
@Composable
fun CreateCharacterPreview() {
    CreateCharacterScreen(rememberNavController())
}