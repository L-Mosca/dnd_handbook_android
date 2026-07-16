package com.moscatech.dndhandbook.presentation.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.domain.models.collection.MonsterCollection
import com.moscatech.dndhandbook.presentation.baseComponents.BaseText
import com.moscatech.dndhandbook.presentation.screen.home.components.HomeBestiary
import com.moscatech.dndhandbook.presentation.screen.home.components.HomeCollection
import com.moscatech.dndhandbook.presentation.ui.theme.Black800
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson800
import com.moscatech.dndhandbook.utils.getCollectionSharedViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToCollection: ((Long?) -> Unit) = {},
    navigateToBestiary: (() -> Unit) = {},
    navigateToSettings: (() -> Unit) = {},
) {
    val context = LocalContext.current
    val collectionViewModel = getCollectionSharedViewModel()

    LaunchedEffect(null) {
        viewModel.getList()
        collectionViewModel.resetData()
    }

    BackHandler {
        (context as? Activity)?.moveTaskToBack(true)
    }

    Home(
        onBestiaryClicked = { navigateToBestiary.invoke() },
        onNewCollectionClicked = {
            collectionViewModel.setCollection(MonsterCollection.newInstance())
            navigateToCollection.invoke(MonsterCollection.NEW_COLLECTION_ID)
        },
        onSettingsClicked = { navigateToSettings.invoke() },
    )
}

@Composable
private fun Home(
    onBestiaryClicked: (() -> Unit)? = null,
    onNewCollectionClicked: (() -> Unit)? = null,
    onSettingsClicked: (() -> Unit) = {},
) {
    Scaffold { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Black800),
        ) {
            Column {
                TopBar(onSettingsClicked = onSettingsClicked)

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    item {
                        Column(
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 30.dp)
                        ) {
                            //CreateCharacterButton(navController = navController)
                            HomeBestiary(onBestiaryClicked = onBestiaryClicked)

                            HomeCollection(addCollectionClicked = onNewCollectionClicked)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(onSettingsClicked: (() -> Unit) = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 10.dp)
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

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = stringResource(R.string.settings),
            tint = Crimson800,
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.CenterEnd)
                .clickable { onSettingsClicked.invoke() }
        )
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