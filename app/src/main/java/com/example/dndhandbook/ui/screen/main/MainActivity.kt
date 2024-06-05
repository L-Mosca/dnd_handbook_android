@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dndhandbook.ui.screen.main

import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.base.BaseActivity
import com.example.dndhandbook.base.BaseViewModel
import com.example.dndhandbook.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val viewModel: BaseViewModel by viewModels()

    @Composable
    override fun ScreenContent() {
        val navController = rememberNavController()
        Surface(color = MaterialTheme.colorScheme.background) {
            NavGraph(navController = navController)
        }
    }
}