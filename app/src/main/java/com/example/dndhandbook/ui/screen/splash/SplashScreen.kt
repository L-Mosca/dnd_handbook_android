package com.example.dndhandbook.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.navigation.Screen
import com.example.dndhandbook.ui.theme.DNDHandbookTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        delay(2000L)
        goToHomeScreen(navController)
    }
    AppLogo()

}

private fun goToHomeScreen(navController: NavHostController) {
    navController.navigate(Screen.Home.route) {
        popUpTo(Screen.Splash.route) { inclusive = true }
    }
}

@Composable
fun AppLogo() {
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
fun ScreenPreview() {
    DNDHandbookTheme {
        AppLogo()
    }
}