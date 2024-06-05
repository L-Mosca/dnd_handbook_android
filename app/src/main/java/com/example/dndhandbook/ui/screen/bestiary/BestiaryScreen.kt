package com.example.dndhandbook.ui.screen.bestiary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R

@Composable
fun BestiaryScreen(
    navController: NavHostController,
    viewModel: BestiaryViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.crimson_900)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ESTE SERÁ O BESTIÁRIO",
            fontSize = 24.sp,
            color = colorResource(id = R.color.white)
        )
    }
}


@Preview
@Composable
fun ScreenPreview() {
    BestiaryScreen(navController = rememberNavController())
}