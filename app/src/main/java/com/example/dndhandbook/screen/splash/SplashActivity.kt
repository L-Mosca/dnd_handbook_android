package com.example.dndhandbook.screen.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityOptionsCompat
import com.example.dndhandbook.R
import com.example.dndhandbook.base.BaseActivity
import com.example.dndhandbook.screen.main.MainActivity
import com.example.dndhandbook.ui.theme.DNDHandbookTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override val viewModel: SplashViewModel by viewModels()

    @Composable
    override fun ScreenContent() {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            delay(2000L)
            goToHomeScreen(context)
        }
        AppLogo(
            modifier = Modifier
        )
    }

    private fun goToHomeScreen(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        val option = ActivityOptionsCompat.makeCustomAnimation(
            context,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        context.startActivity(intent, option.toBundle())
        finish()
    }
}

@Composable
fun AppLogo(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_dnd_logo),
            contentDescription = "image from drawable resource",
            modifier = modifier.size(width = 240.dp, height = 240.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun ScreenPreview() {
    DNDHandbookTheme {
        AppLogo(modifier = Modifier)
    }
}