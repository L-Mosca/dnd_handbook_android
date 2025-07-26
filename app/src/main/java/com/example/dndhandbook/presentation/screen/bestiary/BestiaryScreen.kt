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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.navigation.MonsterDetailRoute
import com.example.dndhandbook.presentation.baseComponents.BaseErrorMessage
import com.example.dndhandbook.presentation.baseComponents.BaseLoading
import com.example.dndhandbook.presentation.screen.bestiary.components.MonsterCard
import com.example.dndhandbook.presentation.screen.bestiary.components.SearchMonsterField
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun BestiaryScreen(
    navController: NavHostController,
    viewModel: BestiaryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Bestiary(
        monsterList = uiState.filterList.results,
        onFilterValueChange = { viewModel.filterMonster(it) },
        onMonsterSelected = {
            navController.navigate(
                MonsterDetailRoute(
                    monsterIndex = it,
                    collectionName = "",
                    isFromCollection = false,
                )
            )
        },
        errorMessage = uiState.error,
        isLoading = uiState.isLoading,
    )
}

@Composable
private fun Bestiary(
    monsterList: List<DefaultObject> = emptyList(),
    onFilterValueChange: ((String) -> Unit)? = null,
    onMonsterSelected: ((String) -> Unit)? = null,
    errorMessage: String? = null,
    isLoading: Boolean = false,
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.background(Black800)) {
                Spacer(modifier = Modifier.height(30.dp))
                SearchMonsterField(onValueChanged = { onFilterValueChange?.invoke(it) })
                Spacer(modifier = Modifier.height((-10).dp))
                BestiaryList(
                    list = monsterList,
                    onMonsterSelected = { onMonsterSelected?.invoke(it) },
                )
            }

            if (!errorMessage.isNullOrBlank()) BaseErrorMessage(errorMessage)
            if (isLoading) BaseLoading()
        }
    }
}

@Composable
private fun BestiaryList(
    list: List<DefaultObject>,
    onMonsterSelected: ((String) -> Unit)? = null,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Black800)
    ) {
        itemsIndexed(list) { index, monster ->
            MonsterCard(
                monster = monster,
                index = index,
                onItemClick = { onMonsterSelected?.invoke(it.index) })
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    val list = mutableListOf<DefaultObject>()
    repeat(20) { list.add(DefaultObject(name = "Nome do Monstro")) }

    Bestiary(monsterList = list)
}