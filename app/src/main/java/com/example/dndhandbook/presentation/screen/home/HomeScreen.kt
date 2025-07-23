package com.example.dndhandbook.presentation.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.navigation.BestiaryNavGraph
import com.example.dndhandbook.navigation.NewCollectionNavGraph
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current

    BackHandler {
        (context as? Activity)?.moveTaskToBack(true)
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Black800),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //CreateCharacterButton(navController = navController)
            BestiaryButton(navController = navController)
            Spacer(Modifier.height(20.dp))
            BaseText(
                text = stringResource(R.string.create_new_collection),
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable { navController.navigate(NewCollectionNavGraph) }
            )
        }
    }
}

@Composable
fun BestiaryButton(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.img_bestiary),
        contentDescription = "image from drawable resource",
        contentScale = ContentScale.Fit,
        modifier = Modifier.clickable { navController.navigate(BestiaryNavGraph) },
    )
}

/*@Composable
fun CreateCharacterButton(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.img_create_character),
        contentDescription = "image from drawable resource",
        contentScale = ContentScale.Fit,
        modifier = Modifier.clickable { navController.navigate(CreateCharacterNavGraph) },
    )
}*/

@Preview
@Composable
fun ScreenPreview() {
    HomeScreen(navController = rememberNavController())
}