package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.extractMonsterSenses
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

@Composable
fun MonsterSenses(senses: Map<String, String> = emptyMap()) {

    if (senses.isEmpty()) return

    MonsterBasicText(
        title = stringResource(id = R.string.senses),
        description = senses.extractMonsterSenses()
    )
}

@Preview
@Composable
fun MonsterSensesPreview() {
    val senses = mapOf(
        "blindsight" to "60 ft.",
        "darkvision" to "120 ft.",
        "passive_perception" to "21",
    )
    MonsterSenses(senses)
}