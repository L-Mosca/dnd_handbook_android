package com.example.dndhandbook.presentation.screen.newCollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.navigation.MonsterDetailRoute
import com.example.dndhandbook.navigation.MonsterListRoute
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionButtons
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionMonsterList
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNameTextField
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNewMonsterButton
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun NewCollectionScreen(
    navController: NavHostController,
    viewModel: NewCollectionViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(null) {
        viewModel.getCollection()
    }

    if (uiState.saveSuccess) navController.popBackStack()

    NewCollection(
        collection = uiState.collection,
        onBackPressed = { navController.popBackStack() },
        onNameChange = { viewModel.updateCollectionName(it) },
        onAddMonsterPressed = {
            navController.navigate(
                route = MonsterListRoute(id = uiState.collection.id)
            )
        },
        onDeleteClicked = { viewModel.deleteMonster(it) },
        onInfoClicked = {
            navController.navigate(
                MonsterDetailRoute(
                    collectionId = uiState.collection.id,
                    monsterIndex = it.index,
                    isFromCollection = false,
                )
            )
        },
        onSaveClicked = { viewModel.save() },
        onDeleteCollectionClicked = { viewModel.deleteCollection() },
    )
}

@Composable
fun NewCollection(
    collection: MonsterCollection = MonsterCollection(),
    onBackPressed: (() -> Unit)? = null,
    onNameChange: (String) -> Unit = {},
    onAddMonsterPressed: (() -> Unit) = {},
    onDeleteClicked: ((DefaultObject) -> Unit)? = null,
    onInfoClicked: ((DefaultObject) -> Unit)? = null,
    onSaveClicked: (() -> Unit)? = null,
    onDeleteCollectionClicked: (() -> Unit)? = null,
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Black800)
                .fillMaxSize(),
        ) {
            TopBar(onBackPressed)

            CollectionNameTextField(collection.name, onNameChange)
            CollectionNewMonsterButton(onAddMonsterPressed)

            CollectionMonsterList(
                list = collection.monsterList ?: emptyList(),
                onDeleteClicked = onDeleteClicked,
                onInfoClicked = onInfoClicked,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp, vertical = 20.dp),
            )

            CollectionButtons(
                onSaveClicked = onSaveClicked,
                onDeleteCollectionClicked = onDeleteCollectionClicked,
                showDeleteButton = collection.id != null,
            )
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
        collection = MonsterCollection(
            name = "collection name",
            monsterList = listOf(
                DefaultObject(name = "Adult brass dragon"),
                DefaultObject(name = "Adult brass dragon"),
                DefaultObject(name = "Adult brass dragon"),
            ),
        ),
    )
}