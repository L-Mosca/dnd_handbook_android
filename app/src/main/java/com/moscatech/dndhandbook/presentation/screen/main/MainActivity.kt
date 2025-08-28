package com.moscatech.dndhandbook.presentation.screen.main

import android.content.Intent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.moscatech.dndhandbook.base.BaseActivity
import com.moscatech.dndhandbook.base.BaseViewModel
import com.moscatech.dndhandbook.navigation.MainNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override val viewModel: BaseViewModel by viewModels()

    lateinit var navController: NavHostController

    @Composable
    override fun ScreenContent() {
        navController = rememberNavController()

        LaunchedEffect(Unit) {
            processDeepLink(intent)
        }

        Surface(color = MaterialTheme.colorScheme.background) {
            MainNavGraph(navController = navController)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        setIntent(intent)
        processDeepLink(intent)
    }

    private fun processDeepLink(intent: Intent) {
        intent.data?.let { uri ->
            val match = Regex("monsterDetailDeepRoute/(.+)$").find(uri.toString())
            match?.groupValues?.get(1)?.let { monsterIndex ->
                navController.navigate("monsterDetailDeepRoute/$monsterIndex") {
                    launchSingleTop = true
                }
            }
        }
    }
}