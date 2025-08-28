package com.moscatech.dndhandbook.domain.models.attributes

import androidx.compose.ui.graphics.Color
import com.moscatech.dndhandbook.domain.models.monster.MonsterDetail
import com.moscatech.dndhandbook.presentation.ui.theme.Black
import com.moscatech.dndhandbook.presentation.ui.theme.Blue700
import com.moscatech.dndhandbook.presentation.ui.theme.Crimson700
import com.moscatech.dndhandbook.presentation.ui.theme.Gold700
import com.moscatech.dndhandbook.presentation.ui.theme.Green700
import com.moscatech.dndhandbook.presentation.ui.theme.Orange700
import com.moscatech.dndhandbook.presentation.ui.theme.Purple700

data class GameAttribute(
    val name: String = "",
    val color: Color = Black,
    val level: Int = 0
)

fun MonsterDetail.extractAttributes(): List<GameAttribute> {
    val list = mutableListOf<GameAttribute>()
    list.add(GameAttribute(name = "STR", color = Crimson700, level = strength))
    list.add(GameAttribute(name = "DEX", color = Green700, level = dexterity))
    list.add(GameAttribute(name = "CON", color = Orange700, level = constitution))
    list.add(GameAttribute(name = "INT", color = Blue700, level = intelligence))
    list.add(GameAttribute(name = "WIS", color = Gold700, level = wisdom))
    list.add(GameAttribute(name = "CHA", color = Purple700, level = charisma))
    return list
}

fun GameAttribute.buildMockList(): List<GameAttribute> {
    val list = mutableListOf<GameAttribute>()
    list.add(GameAttribute(name = "STR", color = Crimson700, level = 10))
    list.add(GameAttribute(name = "DEX", color = Green700, level = 17))
    list.add(GameAttribute(name = "CON", color = Orange700, level = 20))
    list.add(GameAttribute(name = "INT", color = Blue700, level = 11))
    list.add(GameAttribute(name = "WIS", color = Gold700, level = 12))
    list.add(GameAttribute(name = "CHA", color = Purple700, level = 18))
    return list
}