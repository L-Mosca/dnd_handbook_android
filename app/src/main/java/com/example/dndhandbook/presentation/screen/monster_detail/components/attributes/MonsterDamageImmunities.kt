package com.example.dndhandbook.presentation.screen.monster_detail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.capitalizeWords
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText

@Composable
fun MonsterDamageImmunities(immunities: List<String>) {

    if (immunities.isEmpty()) return

    val damageImmunities = immunities.toString().replace("[", "").replace("]", "").capitalizeWords()

    MonsterBasicText(
        title = stringResource(id = R.string.damage_immunities),
        description = damageImmunities
    )
}

@Preview
@Composable
fun MonsterDamageImmunitiesPreview() {
    val immunities = mutableListOf("acid", "fire")
    MonsterDamageImmunities(immunities)
}