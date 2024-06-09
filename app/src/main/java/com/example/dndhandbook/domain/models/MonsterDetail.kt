package com.example.dndhandbook.domain.models

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.MonsterDetailDto
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MonsterDetail(
    val index: String = "",
    val level: Int = 0,
    val name: String = "",
    val url: String = "",
    val desc: String = "",
    val charisma: Int = 0,
    val constitution: Int = 0,
    val dexterity: Int = 0,
    val intelligence: Int = 0,
    val strength: Int = 0,
    val wisdom: Int = 0,
    val image: String = "",
    val size: String = "",      //Possible values: [Tiny, Small, Medium, Large, Huge, Gargantuan]
    val type: String = "",
    val alignment: String = "",//Displacer, beast, Giant, Celestial, Dragon, Elemental, Fey, Aberration, Construct, Fiend, Humanoid, Monstrosity, Plant, Undead, Ooze
    val subtype: String = "", // Possible values: [chaotic neutral, chaotic evil, chaotic good, lawful neutral, lawful evil, lawful good, neutral, neutral evil, neutral good, any alignment, unaligned]
    val armorClass: List<ArmorClass> = emptyList(),
    val hitPoints: Int = 0,
    val hitDice: String = "",
    val actions: @RawValue Any? = null,
    val legendaryActions: @RawValue Any? = null,
    val challengeRating: Double = 0.0, // Possible values: value ≤ 21
    val conditionImmunities: List<MonsterImmunity> = emptyList(),
    val damageImmunities: List<String> = emptyList(),
    val damageResistances: List<String> = emptyList(),
    val damageVulnerabilities: List<String> = emptyList(),
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
    alignment = alignment,
    subtype = subtype,
    armorClass = armorClass,
    hitPoints = hitPoints,
    hitDice = hitDice,
    actions = actions,
    legendaryActions = legendaryActions,
    challengeRating = challengeRating,
    conditionImmunities = conditionImmunities,
    damageImmunities = damageImmunities,
    damageResistances = damageResistances,
    damageVulnerabilities = damageVulnerabilities,
    forms = forms,
    languages = languages,
    proficiencies = proficiencies,
    reactions = reactions,
    senses = senses,
    specialAbilities = specialAbilities,
    speed = speed,
    xp = xp
)

@Parcelize
data class MonsterImmunity(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable

@Parcelize
data class MonsterProficiency(
    @SerializedName("value")
    val value: Int = 0,
    @SerializedName("proficiency")
    val proficiency: Proficiency = Proficiency(),
) : Parcelable

@Parcelize
data class Proficiency(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable

@Parcelize
data class MonsterReaction(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("action_options")
    val actionOptions: @RawValue List<Map<Any, Any>> = emptyList(),
    @SerializedName("choice")
    val choice: MonsterChoice = MonsterChoice(),
) : Parcelable

@Parcelize
data class MonsterChoice(
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("choose")
    val choose: Int = 0,
    @SerializedName("type")
    val type: String = "",
) : Parcelable

@Parcelize
data class MonsterSenses(
    @SerializedName("passive_perception")
    val passivePerception: Int = 0,
    @SerializedName("blindsight")
    val blindSight: String = "",
    @SerializedName("darkvision")
    val darkVision: String = "",
    @SerializedName("tremorsense")
    val tremorSense: String = "",
    @SerializedName("truesight")
    val trueSight: String = "",
) : Parcelable

@Parcelize
data class ArmorClass(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("value")
    val value: Int = 0,
) : Parcelable

@Parcelize
data class Actions(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("multiattack_type")
    val multiAttackType: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("actions")
    val actions: List<ActionType> = emptyList(),
    @SerializedName("attack_bonus")
    val bonusAttack: Int,
) : Parcelable

@Parcelize
data class ActionType(
    @SerializedName("action_name")
    val name: String = "",
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("type")
    val type: String = "",
) : Parcelable