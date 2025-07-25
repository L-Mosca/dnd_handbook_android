package com.example.dndhandbook.presentation.screen.newCollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.navigation.MonsterDetailRoute
import com.example.dndhandbook.navigation.MonsterListRoute
import com.example.dndhandbook.presentation.baseComponents.BaseButton
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionMonsterCard
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNameTextField
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNewMonsterButton
import com.example.dndhandbook.presentation.ui.theme.Black700
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun NewCollectionScreen(
    navController: NavHostController,
    viewModel: NewCollectionViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(null) {
        viewModel.getMonster()
    }

    if (uiState.saveSuccess) navController.popBackStack()

    NewCollection(
        monsterList = uiState.monsterList,
        onBackPressed = { navController.popBackStack() },
        onNameChange = { viewModel.updateCollectionName(it) },
        onAddMonsterPressed = { navController.navigate(MonsterListRoute) },
        onDeleteClicked = { viewModel.deleteMonster(it) },
        onInfoClicked = {
            navController.navigate(
                MonsterDetailRoute(it.index, false)
            )
        },
        onSaveClicked = { viewModel.save() },
        collectionName = uiState.collectionName,
    )
}

@Composable
fun NewCollection(
    monsterList: List<DefaultObject> = emptyList(),
    onBackPressed: (() -> Unit)? = null,
    onNameChange: ((String) -> Unit)? = null,
    onAddMonsterPressed: (() -> Unit) = {},
    onDeleteClicked: ((DefaultObject) -> Unit)? = null,
    onInfoClicked: ((DefaultObject) -> Unit)? = null,
    onSaveClicked: (() -> Unit)? = null,
    collectionName: String = "",
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Black800)
                .fillMaxSize(),
        ) {
            TopBar(onBackPressed)

            CollectionNameTextField(collectionName, onNameChange)
            CollectionNewMonsterButton(onAddMonsterPressed)

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp, vertical = 20.dp)
            ) {
                itemsIndexed(monsterList) { index, monster ->
                    CollectionMonsterCard(
                        monster = monster,
                        onDeleteClicked = { onDeleteClicked?.invoke(it) },
                        onInfoClicked = { onInfoClicked?.invoke(it) }
                    )
                }
            }

            Surface(
                color = Black700,
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp)) {
                    BaseButton(
                        text = stringResource(R.string.save),
                        onClick = { onSaveClicked?.invoke() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBar(onBackPressed: (() -> Unit)? = null) {
    BaseTopBar(
        title = stringResource(R.string.create_new_collection),
        onBackPressed = onBackPressed
    )
}

@Preview
@Composable
fun NewCollectionScreenPreview() {
    NewCollection(
        monsterList = listOf(
            DefaultObject(name = "Adult brass dragon"),
            DefaultObject(name = "Adult brass dragon"),
            DefaultObject(name = "Adult brass dragon")
        )
    )
}