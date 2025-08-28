package com.moscatech.dndhandbook.data.remote.dto.monster

import android.os.Parcelable
import com.moscatech.dndhandbook.domain.models.base.DefaultProficiencyObject
import com.moscatech.dndhandbook.domain.models.monster.Actions
import com.moscatech.dndhandbook.domain.models.monster.ArmorClass
import com.moscatech.dndhandbook.domain.models.monster.LegendaryActions
import com.moscatech.dndhandbook.domain.models.monster.MonsterSpecialAbility
import com.moscatech.dndhandbook.domain.models.monster.MonsterProficiency
import com.moscatech.dndhandbook.domain.models.monster.MonsterReaction
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
    val type: String = "",
    @SerializedName("alignment")
    val alignment: String = "", //Displacer, beast, Giant, Celestial, Dragon, Elemental, Fey, Aberration, Construct, Fiend, Humanoid, Monstrosity, Plant, Undead, Ooze
    @SerializedName("subtype")
    val subtype: String = "", // Possible values: [chaotic neutral, chaotic evil, chaotic good, lawful neutral, lawful evil, lawful good, neutral, neutral evil, neutral good, any alignment, unaligned]
    @SerializedName("armor_class")
    val armorClass: List<ArmorClass> = emptyList(),
    @SerializedName("hit_points")
    val hitPoints: Int = 0,
    @SerializedName("hit_dice")
    val hitDice: String = "",
    @SerializedName("hit_points_roll")
    val hitPointsRoll: String = "",
    @SerializedName("actions")
    val actions: List<Actions> = emptyList(),
    @SerializedName("legendary_actions")
    val legendaryActions: List<LegendaryActions> = emptyList(),
    @SerializedName("challenge_rating")
    val challengeRating: Double = 0.0, // Possible values: value ≤ 21
    @SerializedName("condition_immunities")
    val conditionImmunities: List<DefaultProficiencyObject> = emptyList(),
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
    val proficiencies: List<MonsterProficiency> = emptyList(),
    @SerializedName("reactions")
    val reactions: List<MonsterReaction> = emptyList(),
    @SerializedName("senses")
    val senses: @RawValue Map<String, String> = emptyMap(),
    @SerializedName("special_abilities")
    val specialAbilities: List<MonsterSpecialAbility> = emptyList(),
    @SerializedName("speed")
    val speed: @RawValue Map<String, String> = emptyMap(),
    @SerializedName("xp")
    val xp: Int = 0,
) : Parcelable