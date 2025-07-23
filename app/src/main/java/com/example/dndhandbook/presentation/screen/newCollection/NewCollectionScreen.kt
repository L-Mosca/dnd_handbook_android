package com.example.dndhandbook.presentation.screen.newCollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNameTextField
import com.example.dndhandbook.presentation.screen.newCollection.components.CollectionNewMonsterButton
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun NewCollectionScreen(
    navController: NavHostController,
    viewModel: NewCollectionViewModel = hiltViewModel()
) {
    NewCollection(
        onBackPressed = { navController.popBackStack() },
        onNameChange = { },
        onAddMonsterPressed = { },
    )
}

@Composable
fun NewCollection(
    onBackPressed: (() -> Unit)? = null,
    onNameChange: ((String) -> Unit)? = null,
    onAddMonsterPressed: (() -> Unit) = {},
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Black800)
                .fillMaxSize(),
        ) {
            TopBar(onBackPressed)
            LazyColumn(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                item { CollectionNameTextField(onNameChange) }
                item { CollectionNewMonsterButton(onAddMonsterPressed) }
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
    NewCollection()
}