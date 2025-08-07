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
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionButtons
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionMonsterList
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNameTextField
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNewMonsterButton
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.utils.getCollectionSharedViewModel

@Composable
fun NewCollectionScreen(
    onBackPressed: (() -> Unit) = {},
    onAddMonsterPressed: ((Long?) -> Unit) = {},
    onInfoClicked: ((Long?, String) -> Unit)? = null,
) {
    val collectionSharedViewModel = getCollectionSharedViewModel()
    val uiState by collectionSharedViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        collectionSharedViewModel.resetAddMonsterSuccess()
    }

    if (uiState.deleteSuccess || uiState.saveSuccess) onBackPressed.invoke()

    NewCollection(
        collection = uiState.collection,
        onBackPressed = { onBackPressed.invoke() },
        onNameChange = { collectionSharedViewModel.updateName(it) },
        onAddMonsterPressed = { onAddMonsterPressed.invoke(uiState.collection.id) },
        onDeleteClicked = { collectionSharedViewModel.deleteMonster(it) },
        onInfoClicked = { onInfoClicked?.invoke(uiState.collection.id, it.index) },
        onDeleteCollectionClicked = { collectionSharedViewModel.deleteCollection() },
        onSaveCollectionClicked = { collectionSharedViewModel.saveCollection() },
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
    onDeleteCollectionClicked: (() -> Unit)? = null,
    onSaveCollectionClicked: (() -> Unit)? = null,
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
                onSaveClicked = onSaveCollectionClicked,
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
            id = 0,
            name = "collection name",
            monsterList = listOf(
                DefaultObject(name = "Adult brass dragon"),
                DefaultObject(name = "Adult brass dragon"),
                DefaultObject(name = "Adult brass dragon"),
            ),
        ),
    )
}

@Preview
@Composable
fun NewCollectionEmptyListPreview() {
    NewCollection(
        collection = MonsterCollection(
            id = 0,
            name = "collection name",
            monsterList = emptyList(),
        ),
    )
}