package com.example.dndhandbook.presentation.screen.monster_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.attributes.GameAttribute
import com.example.dndhandbook.domain.models.attributes.buildMockList
import com.example.dndhandbook.domain.models.attributes.extractAttributes
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterArmorClass
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterArmorClassPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterAttributes
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterHitPoints
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterHitPointsPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterName
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpeed
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpeedPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSubtitle

@Composable
fun MonsterDetailScreen(
    navController: NavHostController,
    viewModel: MonsterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    val monsterDetail = state.monsterDetail

    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.black_800))
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize()
            ) {
                with(monsterDetail) {
                    MonsterName(name = name)
                    MonsterSubtitle(size = size, type = type, alignment = alignment)
                    Spacer(modifier = Modifier.height(30.dp))
                    MonsterArmorClass(armorClass)
                    MonsterHitPoints(hitPoints.toString(), hitDice)
                    MonsterSpeed(speed)
                    Spacer(modifier = Modifier.height(20.dp))
                    MonsterAttributes(basicAttrs = extractAttributes())
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.black_800))
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize()
            ) {
                MonsterName(name = "Tyrant Beholder")
                MonsterSubtitle(size = "Large", type = "Undead", alignment = "lawful evil")
                Spacer(modifier = Modifier.height(30.dp))
                MonsterArmorClassPreview()
                MonsterHitPointsPreview()
                MonsterSpeedPreview()
                Spacer(modifier = Modifier.height(20.dp))
                MonsterAttributes(basicAttrs = GameAttribute().buildMockList())
            }
        }
    }
}