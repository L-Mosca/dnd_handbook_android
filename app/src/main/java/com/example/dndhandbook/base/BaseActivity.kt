package com.example.dndhandbook.base

import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.dndhandbook.presentation.ui.theme.DNDHandbookTheme

abstract class BaseActivity : ComponentActivity() {
    abstract val viewModel: BaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            DNDHandbookTheme {
                ScreenContent()
            }
        }
    }

    @Composable
    abstract fun ScreenContent()
}