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
import com.example.dndhandbook.presentation.screen.monster_detail.components.*

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
                    MonsterName(name)
                    MonsterSubtitle(size = size, type = type, alignment = alignment)
                    Spacer(modifier = Modifier.height(30.dp))
                    MonsterArmorClass(armorClass)
                    MonsterHitPoints(hitPoints.toString(), hitDice)
                    MonsterSpeed(speed)
                    MonsterAttributes(extractAttributes())
                    MonsterSavingThrows(proficiencies)
                    MonsterSkills(proficiencies)
                    MonsterDamageImmunities(damageImmunities)
                    MonsterSenses(senses)
                    MonsterLanguages(languages)
                    MonsterChallenge(challengeRating, xp)
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
                MonsterNamePreview()
                MonsterSubtitlePreview()
                Spacer(modifier = Modifier.height(30.dp))
                MonsterArmorClassPreview()
                MonsterHitPointsPreview()
                MonsterSpeedPreview()
                MonsterAttributes(basicAttrs = GameAttribute().buildMockList())
                MonsterSavingThrowsPreview()
                MonsterSkillsPreview()
                MonsterDamageImmunitiesPreview()
                MonsterSensesPreview()
                MonsterLanguagesPreview()
                MonsterChallengePreview()
            }
        }
    }
}