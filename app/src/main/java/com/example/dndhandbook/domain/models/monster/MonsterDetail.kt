package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.monster.MonsterDetailDto
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.base.DefaultProficiencyObject
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
    val hitPointsRoll: String = "",
    val actions: List<Actions> = emptyList(),
    val legendaryActions: List<LegendaryActions> = emptyList(),
    val challengeRating: Double = 0.0, // Possible values: value ≤ 21
    val conditionImmunities: List<DefaultProficiencyObject> = emptyList(),
    val damageImmunities: List<String> = emptyList(),
    val damageResistances: List<String> = emptyList(),
    val damageVulnerabilities: List<String> = emptyList(),
    val forms: @RawValue Any? = null,
    val languages: String = "",
    val proficiencies: List<MonsterProficiency> = emptyList(),
    val reactions: List<MonsterReaction> = emptyList(),
    val senses: @RawValue Map<String, String> = emptyMap(),
    val specialAbilities: List<MonsterSpecialAbility> = emptyList(),
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
    hitPointsRoll = hitPointsRoll,
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
data class MonsterProficiency(
    @SerializedName("value")
    val value: Int = 0,
    @SerializedName("proficiency")
    val proficiency: DefaultObject = DefaultObject(),
) : Parcelable {
    fun isSavingThrow(): Boolean =
        value > -1 && proficiency.name.isNotEmpty() && proficiency.name.contains(
            "Saving Throw"
        )

    fun isSkill(): Boolean =
        value > -1 && proficiency.name.isNotEmpty() && proficiency.name.contains(
            "Skill"
        )
}

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
    val bonusAttack: Int = 0,
    @SerializedName("usage")
    val usage: ActionUsage = ActionUsage()
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

@Parcelize
data class MonsterSpecialAbility(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("usage")
    val usage: SpecialAbilityUsage = SpecialAbilityUsage(),
) : Parcelable

@Parcelize
data class SpecialAbilityUsage(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("times")
    val times: Int = 0,
) : Parcelable

@Parcelize
data class ActionUsage(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("dice")
    val dice: String = "",
    @SerializedName("min_value")
    val minValue: Int = 0
) : Parcelable {

    fun isEmpty(): Boolean {
        return type.isEmpty() && dice.isEmpty() && minValue == 0
    }
}

@Parcelize
data class LegendaryActions(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("desc")
    val desc: String = "",
) : Parcelable