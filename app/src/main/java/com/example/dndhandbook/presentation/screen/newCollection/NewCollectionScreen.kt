package com.example.dndhandbook.presentation.screen.newCollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.presentation.ui.theme.Gold900

@Composable
fun NewCollectionScreen(
    navController: NavHostController,
    viewModel: NewCollectionViewModel = hiltViewModel()
) {
    NewCollection()
}

@Composable
fun NewCollection() {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Gold900)
                .fillMaxSize(),
        ) { }

    }
}

@Preview
@Composable
fun NewCollectionScreenPreview() {
    NewCollection()
}