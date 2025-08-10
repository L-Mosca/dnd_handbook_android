package com.example.dndhandbook.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateToHome: (() -> Unit)? = null,
) {

    val showHome by viewModel.showHome.collectAsState()

    if (showHome) navigateToHome?.invoke()

    AppLogo()
}

@Composable
private fun AppLogo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_dnd_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(width = 240.dp, height = 240.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    AppLogo()
}