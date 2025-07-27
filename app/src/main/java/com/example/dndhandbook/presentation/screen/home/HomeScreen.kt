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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
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
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.navigation.BestiaryRoute
import com.example.dndhandbook.navigation.NewCollectionNavGraph
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.home.components.HomeCollection
import com.example.dndhandbook.presentation.ui.theme.Black800
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current

    LaunchedEffect(null) {
        viewModel.getList()
    }

    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        (context as? Activity)?.moveTaskToBack(true)
    }

    LaunchedEffect(Unit) {
        snapshotFlow { uiState.collectionSelected }
            .distinctUntilChanged()
            .collect { selected ->
                selected?.let {
                    navController.navigate(NewCollectionNavGraph(it.id))
                    viewModel.resetCollection()
                }
            }
    }

    Home(
        onBestiaryClicked = { navController.navigate(BestiaryRoute) },
        onNewCollectionClicked = { viewModel.selectCollection(null) },
        onCollectionClicked = { viewModel.selectCollection(it) },
        collectionList = uiState.collectionList,
    )
}

@Composable
private fun Home(
    onBestiaryClicked: (() -> Unit)? = null,
    onNewCollectionClicked: (() -> Unit)? = null,
    onCollectionClicked: ((MonsterCollection) -> Unit)? = null,
    collectionList: List<MonsterCollection> = emptyList(),
) {
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
            BestiaryButton(onBestiaryClicked)
            Spacer(Modifier.height(20.dp))
            BaseText(
                text = stringResource(R.string.create_new_collection),
                fontSize = 20.sp,
                modifier = Modifier
                    .clickable { onNewCollectionClicked?.invoke() }
            )

            Spacer(Modifier.weight(1f))

            HomeCollection(
                collectionList = collectionList,
                onCollectionClicked = { onCollectionClicked?.invoke(it) },
            )
        }
    }
}

@Composable
private fun BestiaryButton(onBestiaryClicked: (() -> Unit)? = null) {
    Image(
        painter = painterResource(id = R.drawable.img_bestiary),
        contentDescription = "image from drawable resource",
        contentScale = ContentScale.Fit,
        modifier = Modifier.clickable { onBestiaryClicked?.invoke() },
    )
}

/*@Composable
private fun CreateCharacterButton(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.img_create_character),
        contentDescription = "image from drawable resource",
        contentScale = ContentScale.Fit,
        modifier = Modifier.clickable { navController.navigate(CreateCharacterNavGraph) },
    )
}*/

@Preview
@Composable
fun HomePreview() {
    Home()
}