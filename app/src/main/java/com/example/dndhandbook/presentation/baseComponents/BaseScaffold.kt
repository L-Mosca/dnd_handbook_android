package com.example.dndhandbook.presentation.baseComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dndhandbook.presentation.ui.theme.White
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun BaseScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable (TopAppBarScrollBehavior) -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    content: @Composable (
        padding: PaddingValues,
        showSnackBar: (BaseSnackBarConfig) -> Unit,
    ) -> Unit,
) {

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val currentSnackBarConfig = remember { mutableStateOf<BaseSnackBarConfig?>(null) }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val nestedScrollConnection = scrollBehavior.nestedScrollConnection

    Scaffold(
        modifier = modifier.nestedScroll(nestedScrollConnection),
        topBar = { topBar(scrollBehavior) },
        bottomBar = bottomBar,
        snackbarHost = { BuildSnackBar(snackBarHostState, currentSnackBarConfig.value) },
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
    ) { innerPadding ->
        content(innerPadding) { config ->
            coroutineScope.launch {
                currentSnackBarConfig.value = config
                snackBarHostState.showSnackbar(
                    message = config.message,
                    actionLabel = config.actionLabel,
                    duration = config.duration
                )
            }
        }
    }
}

@Composable
fun BuildSnackBar(snackBarHostState: SnackbarHostState, config: BaseSnackBarConfig?) {
    SnackbarHost(
        hostState = snackBarHostState,
        snackbar = {
            config?.let {
                Snackbar(
                    containerColor = it.type.background(),
                    content = { BaseText(text = it.message, fontSize = 20.sp, color = White) },
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                )
            }
        }
    )
}