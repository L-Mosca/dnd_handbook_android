package com.example.dndhandbook.domain.models.attributes

import androidx.annotation.ColorRes
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.MonsterDetail

data class GameAttribute(
    val name: String = "",
    @ColorRes val color: Int = 0,
    val level: Int = 0
)

fun MonsterDetail.extractAttributes(): List<GameAttribute> {
    val list = mutableListOf<GameAttribute>()
    list.add(GameAttribute(name = "STR", color = R.color.crimson_700, level = strength))
    list.add(GameAttribute(name = "DEX", color = R.color.green_700, level = dexterity))
    list.add(GameAttribute(name = "CON", color = R.color.orange_700, level = constitution))
    list.add(GameAttribute(name = "INT", color = R.color.blue_700, level = intelligence))
    list.add(GameAttribute(name = "WIS", color = R.color.gold_700, level = wisdom))
    list.add(GameAttribute(name = "CHA", color = R.color.purple_700, level = charisma))
    return list
}

fun GameAttribute.buildMockList(): List<GameAttribute> {
    val list = mutableListOf<GameAttribute>()
    list.add(GameAttribute(name = "STR", color = R.color.crimson_700, level = 10))
    list.add(GameAttribute(name = "DEX", color = R.color.green_700, level = 17))
    list.add(GameAttribute(name = "CON", color = R.color.orange_700, level = 20))
    list.add(GameAttribute(name = "INT", color = R.color.blue_700, level = 11))
    list.add(GameAttribute(name = "WIS", color = R.color.gold_700, level = 12))
    list.add(GameAttribute(name = "CHA", color = R.color.purple_700, level = 18))
    return list
}