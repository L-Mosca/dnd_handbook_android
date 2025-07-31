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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.baseComponents.placeHolders.EmptyContentPlaceHolder
import com.example.dndhandbook.presentation.baseComponents.placeHolders.ErrorContentPlaceHolder
import com.example.dndhandbook.presentation.baseComponents.placeHolders.LoadingPlaceHolder
import com.example.dndhandbook.presentation.screen.bestiary.components.MonsterCard
import com.example.dndhandbook.presentation.screen.bestiary.components.SearchMonsterField
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun BestiaryScreen(
    viewModel: BestiaryViewModel = hiltViewModel(),
    onBackPressed: (() -> Unit)? = null,
    navigateToMonsterDetail: ((String) -> Unit) = {},
) {
    val uiState by viewModel.uiState.collectAsState()

    Bestiary(
        monsterList = uiState.filterList.results,
        onFilterValueChange = { viewModel.filterMonster(it) },
        onMonsterSelected = { navigateToMonsterDetail.invoke(it) },
        isLoading = uiState.isLoading,
        showEmptyList = uiState.showEmptyList,
        showError = uiState.showError,
        onTryAgainClicked = { viewModel.getMonsters() },
        filterText = uiState.filterText,
        onBackPressed = { onBackPressed?.invoke() }
    )
}

@Composable
private fun Bestiary(
    monsterList: List<DefaultObject> = emptyList(),
    onFilterValueChange: ((String) -> Unit)? = null,
    onMonsterSelected: ((String) -> Unit)? = null,
    isLoading: Boolean = false,
    showEmptyList: Boolean = false,
    showError: Boolean = false,
    onTryAgainClicked: (() -> Unit)? = null,
    filterText: String = "",
    onBackPressed: (() -> Unit)? = null,
) {
    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(modifier = Modifier.background(Black800)) {
                BaseTopBar(
                    title = stringResource(R.string.bestiary),
                    onBackPressed = onBackPressed,
                )
                SearchMonsterField(onValueChanged = { onFilterValueChange?.invoke(it) })
                Spacer(modifier = Modifier.height((-10).dp))
                BestiaryList(
                    list = monsterList,
                    onMonsterSelected = { onMonsterSelected?.invoke(it) },
                )
            }

            ErrorContentPlaceHolder(
                show = showError,
                message = stringResource(R.string.unexpected_error),
                onTryAgainClicked = onTryAgainClicked,
            )
            EmptyContentPlaceHolder(
                show = showEmptyList,
                message = stringResource(R.string.none_monster_match, filterText)
            )
            LoadingPlaceHolder(show = isLoading)
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

    Bestiary(monsterList = list, showEmptyList = false, showError = false)
}

@Preview
@Composable
private fun EmptyListPreview() {
    Bestiary(showEmptyList = true)
}

@Preview
@Composable
private fun ErrorPreview() {
    Bestiary(showError = true)
}