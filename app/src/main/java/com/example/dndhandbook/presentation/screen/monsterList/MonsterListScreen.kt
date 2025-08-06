package com.example.dndhandbook.presentation.screen.monsterList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.example.dndhandbook.presentation.baseComponents.BaseSearchTextField
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.baseComponents.placeHolders.EmptyContentPlaceHolder
import com.example.dndhandbook.presentation.baseComponents.placeHolders.ErrorContentPlaceHolder
import com.example.dndhandbook.presentation.baseComponents.placeHolders.LoadingPlaceHolder
import com.example.dndhandbook.presentation.screen.bestiary.components.MonsterCard
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun MonsterListScreen(
    viewModel: MonsterListViewModel = hiltViewModel(),
    onMonsterClicked: ((Long?, String) -> Unit)? = null,
    onBackPressed: (() -> Unit)? = null,
) {
    val uiState by viewModel.uiState.collectAsState()

    MonsterList(
        isLoading = uiState.isLoading,
        showError = uiState.showError,
        showEmptyPlaceHolder = uiState.showEmptyList,
        filterText = uiState.filterText,
        onFilterChange = { viewModel.filterMonster(it) },
        monsterList = uiState.filterList.results,
        onItemClick = { onMonsterClicked?.invoke(/*uiState.collectionId*/0L, it.index) },
        onTryAgainClicked = { viewModel.getMonsters() },
        onBackPressed = { onBackPressed?.invoke() },
    )
}

@Composable
private fun MonsterList(
    isLoading: Boolean = false,
    showError: Boolean = false,
    showEmptyPlaceHolder: Boolean = false,
    filterText: String = "",
    onFilterChange: ((String) -> Unit)? = null,
    monsterList: List<DefaultObject> = emptyList(),
    onItemClick: ((DefaultObject) -> Unit)? = null,
    onTryAgainClicked: (() -> Unit)? = null,
    onBackPressed: (() -> Unit)? = null,
) {
    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Black800)
                .padding(innerPadding),
        ) {

            Column(modifier = Modifier.fillMaxSize()) {
                BaseTopBar(
                    title = stringResource(R.string.bestiary),
                    onBackPressed = onBackPressed,
                )
                SearchField(onValueChange = onFilterChange, text = filterText)
                Spacer(Modifier.height((-10).dp))
                CardList(list = monsterList, onItemClick = onItemClick)
            }

            ErrorContentPlaceHolder(
                show = showError,
                message = stringResource(R.string.unexpected_error),
                onTryAgainClicked = onTryAgainClicked,
            )
            EmptyContentPlaceHolder(
                show = showEmptyPlaceHolder,
                message = stringResource(R.string.none_monster_match, filterText)
            )
            LoadingPlaceHolder(show = isLoading)
        }
    }
}

@Composable
private fun SearchField(
    onValueChange: ((String) -> Unit)? = null,
    text: String = "",
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BaseSearchTextField(
            text = text,
            hintText = stringResource(id = R.string.search_monster),
            onValueChange = { onValueChange?.invoke(it) },
            onSearchClicked = { },
        )
    }
}

@Composable
private fun CardList(
    list: List<DefaultObject> = emptyList(),
    onItemClick: ((DefaultObject) -> Unit)? = null,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { index, monster ->
            MonsterCard(
                monster = monster,
                index = index,
                onItemClick = { onItemClick?.invoke(it) },
            )
        }
    }
}

@Preview
@Composable
private fun MonsterListScreenPreview() {
    val list = mutableListOf<DefaultObject>()
    repeat(20) { list.add(DefaultObject(name = "Nome do Monstro")) }

    MonsterList(
        monsterList = list,
        showError = false,
        showEmptyPlaceHolder = false,
        isLoading = false,
    )
}

@Preview
@Composable
private fun MonsterListEmptyPreview() {
    MonsterList(showEmptyPlaceHolder = true, showError = false)
}

@Preview
@Composable
private fun MonsterListErrorPreview() {
    MonsterList(showEmptyPlaceHolder = false, showError = true)
}