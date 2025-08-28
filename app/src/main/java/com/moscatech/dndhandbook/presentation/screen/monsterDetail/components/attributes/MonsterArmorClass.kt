package com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.attributes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moscatech.dndhandbook.R
import com.moscatech.dndhandbook.common.extensions_functions.extractArmorClass
import com.moscatech.dndhandbook.domain.models.monster.ArmorClass
import com.moscatech.dndhandbook.presentation.screen.monsterDetail.components.base_components.MonsterBasicText

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