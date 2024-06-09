package com.example.dndhandbook.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MonsterDetailDto(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("charisma")
    val charisma: Int = 0,
    @SerializedName("constitution")
    val constitution: Int = 0,
    @SerializedName("dexterity")
    val dexterity: Int = 0,
    @SerializedName("intelligence")
    val intelligence: Int = 0,
    @SerializedName("strength")
    val strength: Int = 0,
    @SerializedName("wisdom")
    val wisdom: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("size")
    val size: String = "",      //Possible values: [Tiny, Small, Medium, Large, Huge, Gargantuan]
    @SerializedName("type")
    val type: String = "",      //Displacer, beast, Giant, Celestial, Dragon, Elemental, Fey, Aberration, Construct, Fiend, Humanoid, Monstrosity, Plant, Undead, Ooze
    @SerializedName("subtype")
    val subtype: String = "", // Possible values: [chaotic neutral, chaotic evil, chaotic good, lawful neutral, lawful evil, lawful good, neutral, neutral evil, neutral good, any alignment, unaligned]
    @SerializedName("armor_class")
    val armorClass: @RawValue Any? = null,
    @SerializedName("hit_points")
    val hitPoints: Int = 0,
    @SerializedName("hit_dice")
    val hitDice: String = "",
    @SerializedName("actions")
    val actions: @RawValue Any? = null,
    @SerializedName("legendary_actions")
    val legendaryActions: @RawValue Any? = null,
    @SerializedName("challenge_rating")
    val challengeRating: Double = 0.0, // Possible values: value ≤ 21
    @SerializedName("condition_immunities")
    val conditionImmunities: List<MonsterImmunityDto> = emptyList(),
    @SerializedName("damage_immunities")
    val damageImmunities: List<String> = emptyList(),
    @SerializedName("damage_resistances")
    val damageResistances: List<String> = emptyList(),
    @SerializedName("damage_vulnerabilities")
    val damageVulnerabilities: List<String> = emptyList(),
    @SerializedName("forms")
    val forms: @RawValue Any? = null,
    @SerializedName("languages")
    val languages: String = "",
    @SerializedName("proficiencies")
    val proficiencies: List<MonsterProficiencyDto> = emptyList(),
    @SerializedName("reactions")
    val reactions: List<MonsterReactionDto> = emptyList(),
    @SerializedName("senses")
    val senses: MonsterSensesDto = MonsterSensesDto(),
    @SerializedName("special_abilities")
    val specialAbilities: @RawValue Any? = null,
    @SerializedName("speed")
    val speed: @RawValue Any? = null,
    @SerializedName("xp")
    val xp: Int = 0,
) : Parcelable

@Parcelize
data class MonsterImmunityDto(
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
data class MonsterProficiencyDto(
    @SerializedName("value")
    val value: Int = 0,
    @SerializedName("proficiency")
    val proficiency: ProficiencyDto = ProficiencyDto(),
) : Parcelable

@Parcelize
data class ProficiencyDto(
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
data class MonsterReactionDto(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("action_options")
    val actionOptions: @RawValue List<Map<Any, Any>> = emptyList(),
    @SerializedName("choice")
    val choice: MonsterChoiceDto = MonsterChoiceDto(),

    ) : Parcelable

@Parcelize
data class MonsterChoiceDto(
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("choose")
    val choose: Int = 0,
    @SerializedName("type")
    val type: String = "",
) : Parcelable

@Parcelize
data class MonsterSensesDto(
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