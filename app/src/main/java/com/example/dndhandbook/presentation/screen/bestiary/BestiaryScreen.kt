package com.example.dndhandbook.presentation.screen.bestiary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.navigation.MonsterDetailRoute
import com.example.dndhandbook.presentation.baseComponents.BaseErrorMessage
import com.example.dndhandbook.presentation.baseComponents.BaseLoading
import com.example.dndhandbook.presentation.screen.bestiary.components.MonsterCard
import com.example.dndhandbook.presentation.screen.bestiary.components.SearchMonsterField

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
            Column(modifier = Modifier.background(colorResource(id = R.color.black_800))) {
                Spacer(modifier = Modifier.height(30.dp))
                SearchMonsterField(onValueChanged = { inputText ->
                    viewModel.filterMonster(inputText)
                })
                Spacer(modifier = Modifier.height((-10).dp))
                BestiaryList(list = state.filterList.results, navController)
            }

            if (state.error.isNotBlank()) BaseErrorMessage(state.error)
            if (state.isLoading) BaseLoading()
        }
    }
}

@Composable
fun BestiaryList(list: List<DefaultObject>, navController: NavHostController) {
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
    navController.navigate(MonsterDetailRoute(monsterIndex))
}

@Preview
@Composable
fun ScreenPreview() {
    BestiaryScreen(navController = rememberNavController())
}