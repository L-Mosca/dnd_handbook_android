package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MonsterDetail(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("desc")
    val desc: List<String> = emptyList(),
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
    val armorClass: @RawValue Map<String, Any> = emptyMap(),
    @SerializedName("hit_points")
    val hitPoints: Int = 0,
    @SerializedName("hit_dice")
    val hitDice: String = "",
    @SerializedName("actions")
    val actions: @RawValue List<Map<Any, Any>> = emptyList(),
    @SerializedName("legendary_actions")
    val legendaryActions: @RawValue List<Map<Any, Any>> = emptyList(),
    @SerializedName("challenge_rating")
    val challengeRating: Int = 0, // Possible values: value ≤ 21
    @SerializedName("condition_immunities")
    val conditionImmunities: List<MonsterImmunity> = emptyList(),
    @SerializedName("damage_immunities")
    val damageImmunities: String = "",
    @SerializedName("damage_resistances")
    val damageResistances: String = "",
    @SerializedName("damage_vulnerabilities")
    val damageVulnerabilities: String = "",
    @SerializedName("forms")
    val forms: @RawValue Any? = null,
    @SerializedName("languages")
    val languages: String = "",
    @SerializedName("proficiencies")
    val proficiencies: List<MonsterProficiency> = emptyList(),
    @SerializedName("reactions")
    val reactions: List<MonsterReaction> = emptyList(),
    @SerializedName("senses")
    val senses: MonsterSenses = MonsterSenses(),
    @SerializedName("special_abilities")
    val specialAbilities: @RawValue Any? = null,
    @SerializedName("speed")
    val speed: @RawValue Map<String, String> = emptyMap(),
    @SerializedName("xp")
    val xp: Int = 0,
) : Parcelable

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