package com.example.dndhandbook.presentation.screen.monster_detail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.extractSavingThrows
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.monster.MonsterProficiency
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText

@Composable
fun MonsterSavingThrows(proficiencies: List<MonsterProficiency>) {

    if (proficiencies.extractSavingThrows().isBlank()) return

    MonsterBasicText(
        title = stringResource(id = R.string.saving_throws),
        description = proficiencies.extractSavingThrows()
    )
}

@Preview
@Composable
fun MonsterSavingThrowsPreview() {
    val proficiencyList = mutableListOf<MonsterProficiency>()
    proficiencyList.add(
        MonsterProficiency(
            value = 7,
            proficiency = DefaultObject(name = "Saving Throw: DEX")
        )
    )
    proficiencyList.add(
        MonsterProficiency(
            value = 10,
            proficiency = DefaultObject(name = "Saving Throw: CON")
        )
    )
    MonsterSavingThrows(proficiencies = proficiencyList)
}