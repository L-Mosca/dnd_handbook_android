package com.example.dndhandbook.presentation.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.presentation.screen.home.components.HomeBestiary
import com.example.dndhandbook.presentation.screen.home.components.HomeCollection
import com.example.dndhandbook.presentation.ui.theme.Black600
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.utils.getCollectionSharedViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToCollection: ((Long?) -> Unit) = {},
    navigateToBestiary: (() -> Unit) = {},
) {
    val context = LocalContext.current

    val collectionViewModel = getCollectionSharedViewModel()

    LaunchedEffect(null) {
        viewModel.getList()
        collectionViewModel.resetData()
    }

    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        (context as? Activity)?.moveTaskToBack(true)
    }

    /*LaunchedEffect(Unit) {
        snapshotFlow { uiState.collectionSelected }
            .distinctUntilChanged()
            .collect { selected ->
                selected?.let {
                    navigateToCollection.invoke(it.id)
                    viewModel.resetCollection()
                }
            }
    }*/

    Home(
        onBestiaryClicked = { navigateToBestiary.invoke() },
        onNewCollectionClicked = {
            collectionViewModel.setCollection(MonsterCollection.newInstance())
            navigateToCollection.invoke(MonsterCollection.NEW_COLLECTION_ID)
            //viewModel.selectCollection(null)
        },
        onCollectionClicked = {
            collectionViewModel.setCollection(it)
            navigateToCollection.invoke(it.id)
            //viewModel.selectCollection(it)
        },
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
                .background(Black600),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //CreateCharacterButton(navController = navController)
            Spacer(
                Modifier
                    .weight(1f)
                    .background(Black800)
                    .fillMaxWidth()
            )

            Box(
                modifier = Modifier
                    .background(Black800)
                    .offset(x = 0.dp, y = 10.dp)
                    .wrapContentHeight(),
            ) {
                Column(
                    modifier = Modifier
                        .background(Black600)
                        .offset(x = 0.dp, y = (-20).dp)
                ) {
                    HomeBestiary(onBestiaryClicked = onBestiaryClicked)

                    HomeCollection(
                        collectionList = collectionList,
                        onCollectionClicked = { onCollectionClicked?.invoke(it) },
                        addCollectionClicked = onNewCollectionClicked,
                    )
                }
            }
        }
    }
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