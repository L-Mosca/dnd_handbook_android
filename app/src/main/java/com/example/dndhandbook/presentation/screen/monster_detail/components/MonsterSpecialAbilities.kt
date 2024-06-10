package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dndhandbook.domain.models.MonsterSpecialAbility

@Composable
fun MonsterSpecialAbilities(specialAbilities: List<MonsterSpecialAbility> = emptyList()) {

    if (specialAbilities.isEmpty()) return

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomStart) {
        LazyColumn {
            items(specialAbilities) { ability ->
                MonsterSpecialAbility(ability = ability)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun MonsterSpecialAbility(ability: MonsterSpecialAbility) {

}

@Preview
@Composable
fun MonsterSpecialAbilitiesPreview() {
    val list = mutableListOf<MonsterSpecialAbility>()
    MonsterSpecialAbilities()
}