package com.example.dndhandbook.common.extensions_functions

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.dndhandbook.R
import com.example.dndhandbook.domain.models.Actions
import com.example.dndhandbook.domain.models.ArmorClass
import com.example.dndhandbook.domain.models.MonsterProficiency
import com.example.dndhandbook.domain.models.MonsterSpecialAbility
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.NumberFormat
import java.util.Locale

fun List<MonsterProficiency>.extractSavingThrows(): String {
    var savingThrow = ""
    forEach { proficiency ->
        val data = proficiency.proficiency.name
        if (proficiency.isSavingThrow()) {
            savingThrow += "${
                data.substring(
                    data.lastIndex - 3,
                    data.lastIndex + 1
                ).capitalizeWords()
            } +${proficiency.value}, "
        }
    }
    savingThrow = savingThrow.removeSuffix(" ") + ""
    savingThrow = savingThrow.removeSuffix(",") + " "
    return savingThrow
}

fun List<MonsterProficiency>.extractSkills(): String {
    var skill = ""
    forEach { proficiency ->
        val data = proficiency.proficiency.name
        if (proficiency.isSkill()) {
            skill += "${
                data.substringAfter(": ").trim().capitalizeWords()
            } +${proficiency.value}, "
        }
    }
    skill = skill.removeSuffix(" ") + ""
    skill = skill.removeSuffix(",") + " "
    return skill
}


fun List<ArmorClass>.extractArmorClass(): String {
    var armor = ""
    forEach {
        armor += "${it.value} (${it.type})"
    }
    return armor
}

fun Map<String, String>.extractMonsterSpeed(): String {
    var monsterSpeed = ""

    forEach { (type, speed) ->
        monsterSpeed += "$type $speed, "
    }

    monsterSpeed = monsterSpeed.removeSuffix(" ") + ""
    monsterSpeed = monsterSpeed.removeSuffix(",") + " "

    return monsterSpeed
}

fun Map<String, String>.extractMonsterSenses(): String {
    var monsterSense = ""

    forEach { (type, sense) ->
        val description = type.removeUnderscore()
        monsterSense += "$description $sense, "
    }

    monsterSense = monsterSense.removeSuffix(" ") + ""
    monsterSense = monsterSense.removeSuffix(",") + " "

    return monsterSense
}

fun Double.getMonsterChallenge(): String {
    val rating = this
    return if (rating == rating.toInt().toDouble()) {
        rating.toInt().toString()
    } else {
        rating.toString()
    }
}

fun Int.getMonsterXp(): String = "(${NumberFormat.getNumberInstance(Locale.US).format(this)} XP)"

fun MonsterSpecialAbility.extractTitle(): String {
    var title = ""
    val type = if (usage.type == "per day") "${usage.times}/Day" else "${usage.type} ${usage.type}"
    title += name
    if (type.isNotBlank()) title += " ($type)."
    return title
}

fun Actions.getMonsterActionTitle(@ApplicationContext context: Context): String {
    if (usage.isEmpty()) return name

    var title = ""
    title += this.name
    val rechargeType = usage.type.getRechargeType(context)
    title += " ($rechargeType ${usage.minValue}-${usage.dice.getMaxDamage()})"
    return title
}

fun String.getRechargeType(@ApplicationContext context: Context): String {
    return when {
        contains("recharge on roll") -> ContextCompat.getString(context, R.string.recharge)
        else -> this
    }
}

fun String.getMaxDamage(): String {
    if (!contains("d")) return ""

    val diceQuantity = substring(0, indexOf("d")).replace(" ", "").toInt()
    val diceMaxValue = substring(indexOf("d") + 1, lastIndex + 1).replace(" ", "").toInt()

    return "${diceQuantity * diceMaxValue}"
}