package com.example.dndhandbook.presentation.screen.monster_detail.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dndhandbook.R
import com.example.dndhandbook.common.extensions_functions.extractArmorClass
import com.example.dndhandbook.domain.models.ArmorClass

@Composable
fun MonsterArmorClass(armorClass: List<ArmorClass> = emptyList()) {

    if (armorClass.isEmpty()) return

    MonsterBasicText(
        title = stringResource(id = R.string.armor_class),
        description = armorClass.extractArmorClass()
    )
}

@Preview
@Composable
fun MonsterArmorClassPreview() {
    val immunities =
        listOf(ArmorClass(type = "Natural", value = 20), ArmorClass(type = "plate", value = 10))

    MonsterArmorClass(immunities)
}