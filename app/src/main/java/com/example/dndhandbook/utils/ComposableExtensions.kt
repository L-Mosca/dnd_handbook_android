package com.example.dndhandbook.utils

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.presentation.screen.main.CollectionSharedViewModel

@Composable
fun isPreview(): Boolean = LocalInspectionMode.current

@Composable
fun getCollectionSharedViewModel(): CollectionSharedViewModel {
    val activity = LocalContext.current as ComponentActivity
    val viewModel: CollectionSharedViewModel = hiltViewModel(activity)
    return viewModel
}