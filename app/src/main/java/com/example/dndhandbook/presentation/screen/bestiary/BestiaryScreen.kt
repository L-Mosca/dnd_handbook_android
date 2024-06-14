package com.example.dndhandbook.presentation.screen.bestiary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.MonsterBasicData
import com.example.dndhandbook.navigation.Screen
import com.example.dndhandbook.presentation.base_components.BaseText
import com.example.dndhandbook.presentation.screen.bestiary.components.MonsterCard

@Composable
fun BestiaryScreen(
    navController: NavHostController,
    viewModel: BestiaryViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            BestiaryList(list = state.monsterList.results, navController)

            if (state.error.isNotBlank()) BestiaryError(state.error)
            if (state.isLoading) BestiaryLoading()
        }
    }
}

@Composable
fun BestiaryList(list: List<MonsterBasicData>, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black_800))
    ) {
        itemsIndexed(list) { index, monster ->
            MonsterCard(
                monster = monster,
                index = index,
                onItemClick = { navigateToMonsterDetail(monster.index, navController) })
        }
    }
}

private fun navigateToMonsterDetail(monsterIndex: String, navController: NavHostController) {
    navController.navigate(Screen.MonsterDetail.route + "/$monsterIndex")
}

@Composable
fun BestiaryError(errorMessage: String) {
    BaseText(
        text = errorMessage,
        fontSize = 18.sp,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        textOverflow = TextOverflow.Ellipsis,
        padding = 20.dp,
        color = colorResource(id = R.color.crimson_800)
    )
}

@Composable
fun BestiaryLoading() {
    CircularProgressIndicator(color = colorResource(id = R.color.crimson_800))
}

@Preview
@Composable
fun ScreenPreview() {
}