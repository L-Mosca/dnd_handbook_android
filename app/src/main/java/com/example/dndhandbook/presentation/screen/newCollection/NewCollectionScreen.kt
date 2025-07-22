package com.example.dndhandbook.presentation.screen.newCollection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.baseComponents.BaseTopBar
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun NewCollectionScreen(
    navController: NavHostController,
    viewModel: NewCollectionViewModel = hiltViewModel()
) {
    NewCollection()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCollection() {
    Scaffold(
        topBar = {
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            BaseTopBar(
                title = "Teste da app bar",
                onBackPressed = {},
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Black800)
                .fillMaxSize(),
        ) {

        }
    }
}

@Preview
@Composable
fun NewCollectionScreenPreview() {
    NewCollection()
}