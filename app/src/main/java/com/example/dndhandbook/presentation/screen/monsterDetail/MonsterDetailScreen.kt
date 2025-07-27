package com.example.dndhandbook.presentation.screen.monsterDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.dndhandbook.domain.models.attributes.GameAttribute
import com.example.dndhandbook.domain.models.attributes.buildMockList
import com.example.dndhandbook.domain.models.attributes.extractAttributes
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.navigation.NewCollectionRoute
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterArmorClass
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterArmorClassPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterAttributes
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterChallenge
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterChallengePreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterDamageImmunities
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterDamageImmunitiesPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterHitPoints
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterHitPointsPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterLanguages
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterLanguagesPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSavingThrows
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSavingThrowsPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSenses
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSensesPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSpeed
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSpeedPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterImage
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.AddMonsterButton
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.AddMonsterButtonPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterName
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterNamePreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterSubtitlePreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterActions
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterLegendaryActions
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterLegendaryActionsPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSkills
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSkillsPreview
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSpecialAbilities
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSpecialAbilitiesPreview
import com.example.dndhandbook.presentation.ui.theme.Black800

@Composable
fun MonsterDetailScreen(
    navController: NavHostController,
    viewModel: MonsterDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val monsterDetail = uiState.monsterDetail

    if (uiState.navigateBack) {
        navController.popBackStack(
            route = NewCollectionRoute(id = uiState.collectionId),
            inclusive = false,
        )
    }

    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(Black800)
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
                    if (uiState.isFromCollection) item {
                        AddMonsterButton(onClick = {
                            viewModel.saveMonsterDetail(DefaultObject(index, name, url))
                        })
                    }
                    item { MonsterImage(url = image) }
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
                .background(Black800)
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
                item { AddMonsterButtonPreview() }
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