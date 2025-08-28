package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.capitalizeWords
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

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