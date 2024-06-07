package com.example.dndhandbook.ui.screen.bestiary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.monster.MonsterBasicData
import com.example.dndhandbook.ui.screen.bestiary.components.MonsterCard

@Composable
fun BestiaryScreen(
    navController: NavHostController,
    viewModel: BestiaryViewModel = hiltViewModel()
) {
    val list = mutableListOf<MonsterBasicData>()
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/adult--dragon.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/aboleth.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/zombie.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/adult-black-dragon.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/aboleth.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/zombie.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/adult-black-dragon.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/aboleth.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/zombie.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/adult-black-dragon.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/aboleth.png"
        )
    )
    list.add(
        MonsterBasicData(
            name = "Nome do Monstror",
            image = "https://www.dnd5eapi.co/api/images/monsters/zombie.png"
        )
    )

    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(colorResource(id = R.color.black_800))
                .padding(innerPadding)
        ) {
            MonsterList(list = list)
        }
    }
}

@Composable
private fun MonsterList(list: List<MonsterBasicData>) {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2),
    ) {
        items(list.size) { index ->
            Box(contentAlignment = Alignment.Center) {
                MonsterCard(monster = list[index])
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    BestiaryScreen(navController = rememberNavController())
}