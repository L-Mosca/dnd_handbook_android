package com.moscatech.dndhandbook.utils

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.moscatech.dndhandbook.presentation.screen.main.CollectionSharedViewModel

@Composable
fun isPreview(): Boolean = LocalInspectionMode.current

@Composable
fun getCollectionSharedViewModel(): CollectionSharedViewModel {
    val activity = LocalContext.current as ComponentActivity
    val viewModel: CollectionSharedViewModel = hiltViewModel(activity)
    return viewModel
}

fun openUrlInApp(url: String?, context: Context) {
    url?.let {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, it.toUri())
    }
}