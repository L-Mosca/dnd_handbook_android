package com.example.dndhandbook.ui.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val context = LocalContext.current

    BackHandler {
        (context as? Activity)?.moveTaskToBack(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black_800)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BestiaryButton(navController = navController)
    }
}

@Composable
fun BestiaryButton(navController: NavHostController) {
    Image(
        painter = painterResource(id = R.drawable.img_bestiary),
        contentDescription = "image from drawable resource",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(width = 140.dp, height = 140.dp)
            .clickable {
                navController.navigate(Screen.Bestiary.route)
            },
    )
}

@Preview
@Composable
fun ScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black_800)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BestiaryButton(navController = rememberNavController())
    }
}

/*
Bottom navigation bar code:

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Bestiary",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false
        ),
    )

    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(bottomBar = {
        NavigationBar(
            tonalElevation = 4.dp,
            containerColor = colorResource(id = R.color.black_700),
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(selected = selectedIndex == index, onClick = {
                    selectedIndex = index
                    // TODO navigation action here
                },
                    label = {
                        Text(
                            text = item.title,
                            color = colorResource(
                                id = if (index == selectedIndex) R.color.crimson_500
                                else R.color.gray_700
                            ),
                        )
                    },
                    icon = {
                        BadgedBox(badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }) {
                            Icon(
                                imageVector = if (index == selectedIndex) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title,
                                tint = if (index == selectedIndex) colorResource(id = R.color.crimson_800)
                                else colorResource(id = R.color.gray_700)
                            )
                        }
                    })
            }
        }
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.black_800))
                .fillMaxSize()
        )
    }
}


@Preview
@Composable
fun ScreenPreview() {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Bestiary",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false
        ),
    )

    Scaffold(bottomBar = {
        NavigationBar(
            tonalElevation = 4.dp,
            containerColor = colorResource(id = R.color.black_700),
        ) {
            items.forEachIndexed { _, item ->
                NavigationBarItem(selected = false, onClick = {

                    // TODO navigation action here
                },
                    label = {
                        Text(
                            text = item.title,
                            color = colorResource(
                                id = R.color.crimson_500
                            ),
                        )
                    },
                    icon = {
                        BadgedBox(badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }) {
                            Icon(
                                imageVector = item.selectedIcon,
                                contentDescription = item.title,
                                tint = colorResource(id = R.color.crimson_800)

                            )
                        }
                    })
            }
        }
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(colorResource(id = R.color.black_800))
                .fillMaxSize()
        )
    }
}
*/