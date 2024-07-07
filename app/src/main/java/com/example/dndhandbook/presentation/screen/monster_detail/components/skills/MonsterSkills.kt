package com.example.dndhandbook.presentation.screen.monster_detail.components.skills

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.extractSkills
import com.example.dndhandbook.domain.models.monster.MonsterProficiency
import com.example.dndhandbook.domain.models.monster.Proficiency
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText

@Composable
fun MonsterSkills(proficiencies: List<MonsterProficiency>) {

    if (proficiencies.extractSkills().isBlank()) return

    MonsterBasicText(
        title = stringResource(id = R.string.skills),
        description = proficiencies.extractSkills()
    )
}

@Preview
@Composable
fun MonsterSkillsPreview() {
    val proficiencyList = mutableListOf<MonsterProficiency>()
    proficiencyList.add(
        MonsterProficiency(
            value = 11,
            proficiency = Proficiency(name = "Skill: Perception")
        )
    )
    proficiencyList.add(
        MonsterProficiency(
            value = 7,
            proficiency = Proficiency(name = "Skill: Stealth")
        )
    )
    MonsterSkills(proficiencies = proficiencyList)
}