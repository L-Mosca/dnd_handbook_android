package com.example.dndhandbook.presentation.screen.monsterDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.attributes.extractAttributes
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.monster.Actions
import com.example.dndhandbook.domain.models.monster.ArmorClass
import com.example.dndhandbook.domain.models.monster.LegendaryActions
import com.example.dndhandbook.domain.models.monster.MonsterDetail
import com.example.dndhandbook.domain.models.monster.MonsterProficiency
import com.example.dndhandbook.domain.models.monster.MonsterSpecialAbility
import com.example.dndhandbook.domain.models.monster.SpecialAbilityUsage
import com.example.dndhandbook.presentation.baseComponents.placeHolders.ErrorContentPlaceHolder
import com.example.dndhandbook.presentation.baseComponents.placeHolders.LoadingPlaceHolder
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterArmorClass
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterAttributes
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterChallenge
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterDamageImmunities
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterHitPoints
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterLanguages
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSavingThrows
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSenses
import com.example.dndhandbook.presentation.screen.monsterDetail.components.attributes.MonsterSpeed
import com.example.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterImage
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.AddMonsterButton
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterName
import com.example.dndhandbook.presentation.screen.monsterDetail.components.basic_data.MonsterSubtitle
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterActions
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterLegendaryActions
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSkills
import com.example.dndhandbook.presentation.screen.monsterDetail.components.skills.MonsterSpecialAbilities
import com.example.dndhandbook.presentation.ui.theme.Black800
import com.example.dndhandbook.presentation.ui.theme.Gray100
import com.example.dndhandbook.utils.getCollectionSharedViewModel

@Composable
fun MonsterDetailScreen(
    viewModel: MonsterDetailViewModel = hiltViewModel(),
    onMonsterAdded: ((Long?) -> Unit)? = null,
    onBackPressed: (() -> Unit)? = null,
) {
    val collectionSharedViewModel = getCollectionSharedViewModel()

    val uiState by viewModel.uiState.collectAsState()
    val newCollectionUiState by collectionSharedViewModel.uiState.collectAsState()

    //if (uiState.navigateBack) onMonsterAdded?.invoke(/*uiState.collectionId*/0L)

    if (newCollectionUiState.addMonsterSuccess) onMonsterAdded?.invoke(newCollectionUiState.collection.id)

    MonsterDetail(
        monsterDetail = uiState.monsterDetail,
        isFromCollection = uiState.isFromCollection,
        onSaveMonsterClicked = { collectionSharedViewModel.addMonster(it) },
        showLoading = uiState.isLoading,
        showError = uiState.showError,
        onTryAgainClicked = { viewModel.getMonsterDetail() },
        onBackPressed = { onBackPressed?.invoke() },
    )
}

@Composable
private fun MonsterDetail(
    monsterDetail: MonsterDetail? = null,
    isFromCollection: Boolean = false,
    onSaveMonsterClicked: ((DefaultObject) -> Unit)? = null,
    showLoading: Boolean = false,
    showError: Boolean = false,
    onTryAgainClicked: (() -> Unit)? = null,
    onBackPressed: (() -> Unit)? = null,
) {
    Scaffold { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Black800)
                .padding(innerPadding),
        ) {
            Details(
                monsterDetail = monsterDetail,
                isFromCollection = isFromCollection,
                onSaveMonsterClicked = onSaveMonsterClicked,
                onBackPressed = onBackPressed,
            )

            ErrorContentPlaceHolder(
                show = showError,
                message = stringResource(R.string.unexpected_error),
                onTryAgainClicked = onTryAgainClicked,
            )
            LoadingPlaceHolder(show = showLoading)
        }
    }
}

@Composable
private fun Details(
    monsterDetail: MonsterDetail? = null,
    isFromCollection: Boolean = false,
    onSaveMonsterClicked: ((DefaultObject) -> Unit)?,
    onBackPressed: (() -> Unit)? = null,
) {

    monsterDetail?.run {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = { onBackPressed?.invoke() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = Gray100,
                    )
                }
                Column(modifier = Modifier.align(Alignment.Center)) {
                    MonsterName(name)
                    MonsterSubtitle(size = size, type = type, alignment = alignment)
                }
            }
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize(),
            ) {
                item {
                    AddMonsterButton(
                        isFromCollection = isFromCollection,
                        onClick = {
                            onSaveMonsterClicked?.invoke(DefaultObject(index, name, url))
                        }
                    )
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

@Preview
@Composable
private fun MonsterDetailPreview() {
    MonsterDetail(
        showError = false,
        showLoading = false,
        monsterDetail = MonsterDetail(
            name = "monster name",
            desc = "monster description",
            alignment = "chaotic evil",
            type = "beast",
            size = "large",
            armorClass = listOf(ArmorClass(type = "type", value = 20)),
            hitPoints = 10,
            hitDice = "hit dice",
            speed = mapOf(Pair("speed", "90 ft")),
            strength = 10,
            dexterity = 10,
            intelligence = 10,
            charisma = 10,
            wisdom = 10,
            constitution = 10,
            proficiencies = listOf(
                MonsterProficiency(
                    value = 10,
                    proficiency = DefaultObject(name = "proficiency")
                )
            ),
            damageImmunities = listOf("immunity 1", "immunity 2"),
            senses = mapOf(Pair("sense", "sense")),
            languages = "languages",
            challengeRating = 1000.0,
            xp = 1000,
            specialAbilities = listOf(
                MonsterSpecialAbility(
                    name = "abilities",
                    desc = "description",
                    usage = SpecialAbilityUsage(type = "usage", times = 2)
                )
            ),
            actions = listOf(Actions(name = "actions", desc = "Description")),
            legendaryActions = listOf(
                LegendaryActions(
                    name = "legendary actions",
                    desc = "description"
                )
            )
        ),
    )
}

@Preview
@Composable
private fun LoadingPreview() {
    MonsterDetail(
        showError = false,
        showLoading = true,
        monsterDetail = null,
    )
}

@Preview
@Composable
private fun ErrorPreview() {
    MonsterDetail(
        showError = true,
        showLoading = false,
        monsterDetail = null,
    )
}