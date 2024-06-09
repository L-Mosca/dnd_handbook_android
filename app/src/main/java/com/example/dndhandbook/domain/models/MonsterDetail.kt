package com.example.dndhandbook.domain.models

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.MonsterChoiceDto
import com.example.dndhandbook.data.remote.dto.MonsterDetailDto
import com.example.dndhandbook.data.remote.dto.MonsterImmunityDto
import com.example.dndhandbook.data.remote.dto.MonsterProficiencyDto
import com.example.dndhandbook.data.remote.dto.MonsterReactionDto
import com.example.dndhandbook.data.remote.dto.MonsterSensesDto
import com.example.dndhandbook.data.remote.dto.ProficiencyDto
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MonsterDetail(
    val index: String = "",
    val level: Int = 0,
    val name: String = "",
    val url: String = "",
    val desc: List<String> = emptyList(),
    val charisma: Int = 0,
    val constitution: Int = 0,
    val dexterity: Int = 0,
    val intelligence: Int = 0,
    val strength: Int = 0,
    val wisdom: Int = 0,
    val image: String = "",
    val size: String = "",      //Possible values: [Tiny, Small, Medium, Large, Huge, Gargantuan]
    val type: String = "",      //Displacer, beast, Giant, Celestial, Dragon, Elemental, Fey, Aberration, Construct, Fiend, Humanoid, Monstrosity, Plant, Undead, Ooze
    val subtype: String = "", // Possible values: [chaotic neutral, chaotic evil, chaotic good, lawful neutral, lawful evil, lawful good, neutral, neutral evil, neutral good, any alignment, unaligned]
    val armorClass: @RawValue Map<String, Any> = emptyMap(),
    val hitPoints: Int = 0,
    val hitDice: String = "",
    val actions: @RawValue List<Map<Any, Any>> = emptyList(),
    val legendaryActions: @RawValue List<Map<Any, Any>> = emptyList(),
    val challengeRating: Int = 0, // Possible values: value ≤ 21
    val conditionImmunities: List<MonsterImmunity> = emptyList(),
    val damageImmunities: String = "",
    val damageResistances: String = "",
    val damageVulnerabilities: String = "",
    val forms: @RawValue Any? = null,
    val languages: String = "",
    val proficiencies: List<MonsterProficiency> = emptyList(),
    val reactions: List<MonsterReaction> = emptyList(),
    val senses: MonsterSenses = MonsterSenses(),
    val specialAbilities: @RawValue Any? = null,
    val speed: @RawValue Map<String, String> = emptyMap(),
    val xp: Int = 0,
) : Parcelable

fun MonsterDetailDto.toMonsterDetail(): MonsterDetail = MonsterDetail(
    index = index,
    level = level,
    name = name,
    url = url,
    desc = desc,
    charisma = charisma,
    constitution = constitution,
    dexterity = dexterity,
    intelligence = intelligence,
    strength = strength,
    wisdom = wisdom,
    image = image,
    size = size,
    type = type,
    subtype = subtype,
    armorClass = armorClass,
    hitPoints = hitPoints,
    hitDice = hitDice,
    actions = actions,
    legendaryActions = legendaryActions,
    challengeRating = challengeRating,
    conditionImmunities = conditionImmunities.toMonsterImmunityList(),
    damageImmunities = damageImmunities,
    damageResistances = damageResistances,
    damageVulnerabilities = damageVulnerabilities,
    forms = forms,
    languages = languages,
    proficiencies = proficiencies.toMonsterProficiencyList(),
    reactions = reactions.toMonsterReactionList(),
    senses = senses.toMonsterSenses(),
    specialAbilities = specialAbilities,
    speed = speed,
    xp = xp
)

@Parcelize
data class MonsterImmunity(
    val index: String = "",
    val level: Int = 0,
    val name: String = "",
    val url: String = "",
) : Parcelable

fun MonsterImmunityDto.toMonsterImmunity(): MonsterImmunity = MonsterImmunity(
    index = index,
    level = level,
    name = name,
    url = url,
)

fun List<MonsterImmunityDto>.toMonsterImmunityList(): List<MonsterImmunity> {
    val list = mutableListOf<MonsterImmunity>()
    forEach {
        list.add(it.toMonsterImmunity())
    }
    return list
}

@Parcelize
data class MonsterProficiency(
    val value: Int = 0,
    val proficiency: Proficiency = Proficiency(),
) : Parcelable

fun MonsterProficiencyDto.toMonsterProficiency(): MonsterProficiency = MonsterProficiency(
    value = value,
    proficiency = proficiency.toProficiency()
)

fun List<MonsterProficiencyDto>.toMonsterProficiencyList(): List<MonsterProficiency> {
    val list = mutableListOf<MonsterProficiency>()
    forEach {
        list.add(it.toMonsterProficiency())
    }
    return list
}

@Parcelize
data class Proficiency(
    val index: String = "",
    val level: Int = 0,
    val name: String = "",
    val url: String = "",
) : Parcelable

fun ProficiencyDto.toProficiency(): Proficiency = Proficiency(
    index = index,
    level = level,
    name = name,
    url = url,
)

@Parcelize
data class MonsterReaction(
    val name: String = "",
    val desc: String = "",
    val actionOptions: @RawValue List<Map<Any, Any>> = emptyList(),
    val choice: MonsterChoice = MonsterChoice(),
) : Parcelable

fun MonsterReactionDto.toMonsterReaction(): MonsterReaction = MonsterReaction(
    name = name,
    desc = desc,
    actionOptions = actionOptions,
    choice = choice.toMonsterChoice()
)

fun List<MonsterReactionDto>.toMonsterReactionList(): List<MonsterReaction> {
    val list = mutableListOf<MonsterReaction>()
    forEach {
        list.add(it.toMonsterReaction())
    }
    return list
}

@Parcelize
data class MonsterChoice(
    val desc: String = "",
    val choose: Int = 0,
    val type: String = "",
) : Parcelable

fun MonsterChoiceDto.toMonsterChoice(): MonsterChoice = MonsterChoice(
    desc = desc,
    choose = choose,
    type = type
)

@Parcelize
data class MonsterSenses(
    val passivePerception: Int = 0,
    val blindSight: String = "",
    val darkVision: String = "",
    val tremorSense: String = "",
    val trueSight: String = "",
) : Parcelable

fun MonsterSensesDto.toMonsterSenses(): MonsterSenses = MonsterSenses(
    passivePerception = passivePerception,
    blindSight = blindSight,
    darkVision = darkVision,
    tremorSense = tremorSense,
    trueSight = trueSight
)