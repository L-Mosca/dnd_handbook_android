@file:OptIn(ExperimentalMaterial3Api::class)

package com.moscatech.dndhandbook.presentation.screen.collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.presentation.baseComponents.BaseScaffold
import com.moscatech.dndhandbook.presentation.baseComponents.BaseTopBar
import com.moscatech.dndhandbook.presentation.screen.collection.components.CollectionEmptyList
import com.moscatech.dndhandbook.presentation.screen.collection.components.CollectionList
import com.moscatech.dndhandbook.presentation.screen.collection.components.NewCollectionButton
import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.utils.getCollectionSharedViewModel

@Composable
fun CollectionScreen(
    viewModel: CollectionViewModel = hiltViewModel(),
    navigateToCollection: ((Long?) -> Unit) = {},
    onBackPressed: (() -> Unit)? = null,
) {

    val collectionViewModel = getCollectionSharedViewModel()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(null) {
        viewModel.getList()
        collectionViewModel.resetData()
    }

    Screen(
        onCollectionClicked = {
            collectionViewModel.setCollection(it)
            navigateToCollection.invoke(it.id)
        },
        collectionList = uiState.collectionList,
        onNewCollectionClicked = {
            collectionViewModel.setCollection(MonsterCollection.newInstance())
            navigateToCollection.invoke(MonsterCollection.NEW_COLLECTION_ID)
        },
        onBackPressed = onBackPressed
    )
}

@Composable
private fun Screen(
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
    collectionList: List<MonsterCollection> = emptyList(),
    onNewCollectionClicked: (() -> Unit)? = null,
    onBackPressed: (() -> Unit)? = null,
) {
    BaseScaffold(topBar = { scrollBehavior ->
        BaseTopBar(
            title = stringResource(R.string.collections),
            onBackClick = onBackPressed,
            scrollBehavior = scrollBehavior,
        )
    }) { innerPadding, _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Black800),
        ) {
            Column {
                if (collectionList.isEmpty())
                    CollectionEmptyList(
                        Modifier
                            .fillMaxSize()
                            .padding(bottom = 50.dp)
                    )

                CollectionList(
                    collectionList = collectionList,
                    onCollectionClicked = onCollectionClicked
                )
            }

            NewCollectionButton(
                onNewCollectionClicked = { onNewCollectionClicked?.invoke() },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
private fun CollectionScreenPreview() {
    val list = mutableListOf<MonsterCollection>()
    repeat(10) {
        list.add(MonsterCollection(name = "collection name"))
    }
    Screen(collectionList = list)
}

@Preview
@Composable
private fun CollectionEmptyListScreenPreview() {
    Screen()
}