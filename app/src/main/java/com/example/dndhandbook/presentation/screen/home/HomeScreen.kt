package com.example.dndhandbook.presentation.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.collection.MonsterCollection
import com.example.dndhandbook.presentation.baseComponents.BaseText
import com.example.dndhandbook.presentation.screen.home.components.HomeBestiary
import com.example.dndhandbook.presentation.screen.home.components.HomeCollection
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Crimson800
import com.example.dndhandbook.utils.getCollectionSharedViewModel

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

    Home(
        onBestiaryClicked = { navigateToBestiary.invoke() },
        onNewCollectionClicked = {
            collectionViewModel.setCollection(MonsterCollection.newInstance())
            navigateToCollection.invoke(MonsterCollection.NEW_COLLECTION_ID)
        },
        onCollectionClicked = {
            collectionViewModel.setCollection(it)
            navigateToCollection.invoke(it.id)
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

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Black800),
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    BaseText(
                        text = stringResource(R.string.app_name),
                        fontSize = 24.sp,
                        color = Crimson800,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                    )
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    item {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize().padding(top = 30.dp)
                        ) {
                            //CreateCharacterButton(navController = navController)
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