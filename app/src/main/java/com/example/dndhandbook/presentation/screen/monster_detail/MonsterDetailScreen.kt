package com.example.dndhandbook.presentation.screen.monster_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterActions
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterArmorClass
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterArmorClassPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterAttributes
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterChallenge
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterChallengePreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterDamageImmunities
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterDamageImmunitiesPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterHitPoints
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterHitPointsPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterLanguages
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterLanguagesPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterLegendaryActions
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterLegendaryActionsPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterName
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterNamePreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSavingThrows
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSavingThrowsPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSenses
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSensesPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSkills
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSkillsPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpecialAbilities
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpecialAbilitiesPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpeed
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSpeedPreview
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSubtitle
import com.example.dndhandbook.presentation.screen.monster_detail.components.MonsterSubtitlePreview

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
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize(),
            ) {
                with(monsterDetail) {
                    item { MonsterName(name) }
                    item { MonsterSubtitle(size = size, type = type, alignment = alignment) }
                    item { Spacer(modifier = Modifier.height(30.dp)) }
                    item { MonsterArmorClass(armorClass) }
                    item { MonsterHitPoints(hitPoints.toString(), hitDice) }
                    item { MonsterSpeed(speed) }
                    item { MonsterAttributes(extractAttributes()) }
                    item { MonsterSavingThrows(proficiencies) }
                    item { MonsterSkills(proficiencies) }
                    item { MonsterDamageImmunities(damageImmunities) }
                    item { MonsterSenses(senses) }
                    item { MonsterLanguages(languages) }
                    item { MonsterChallenge(challengeRating, xp) }
                    item { MonsterSpecialAbilities(specialAbilities) }
                    item { MonsterActions(actions) }
                    item { MonsterLegendaryActions(legendaryActions) }
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
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize(),
            ) {
                item { MonsterNamePreview() }
                item { MonsterSubtitlePreview() }
                item { Spacer(modifier = Modifier.height(30.dp)) }
                item { MonsterArmorClassPreview() }
                item { MonsterHitPointsPreview() }
                item { MonsterSpeedPreview() }
                item { MonsterAttributes(basicAttrs = GameAttribute().buildMockList()) }
                item { MonsterSavingThrowsPreview() }
                item { MonsterSkillsPreview() }
                item { MonsterDamageImmunitiesPreview() }
                item { MonsterSensesPreview() }
                item { MonsterLanguagesPreview() }
                item { MonsterChallengePreview() }
                item { MonsterSpecialAbilitiesPreview() }
                item { MonsterLegendaryActionsPreview() }
            }
        }
    }
}