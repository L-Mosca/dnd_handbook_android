package com.example.dndhandbook.presentation.screen.monster_detail.components.skills

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.extractTitle
import com.example.dndhandbook.domain.models.MonsterSpecialAbility
import com.example.dndhandbook.domain.models.SpecialAbilityUsage
import com.example.dndhandbook.presentation.screen.monster_detail.components.base_components.MonsterBasicText

@Composable
fun MonsterSpecialAbilities(specialAbilities: List<MonsterSpecialAbility> = emptyList()) {

    if (specialAbilities.isEmpty()) return

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            specialAbilities.forEach {
                MonsterSpecialAbility(ability = it)
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun MonsterSpecialAbility(ability: MonsterSpecialAbility) {
    MonsterBasicText(
        title = ability.extractTitle(),
        titleColor = R.color.gold_700,
        description = ability.desc,
    )
}

@Preview
@Composable
fun MonsterSpecialAbilitiesPreview() {
    val list = mutableListOf<MonsterSpecialAbility>()
    list.add(
        MonsterSpecialAbility(
            name = "Legendary Resistance",
            desc = "If the dragon fails a saving throw, it can choose to succeed instead.",
            usage = SpecialAbilityUsage(type = "per day", times = 3)
        )
    )
    list.add(
        MonsterSpecialAbility(
            name = "Legendary Resistance",
            desc = "If the dragon fails a saving throw, it can choose to succeed instead.",
            usage = SpecialAbilityUsage(type = "per day", times = 3)
        )
    )
    MonsterSpecialAbilities(list)
}