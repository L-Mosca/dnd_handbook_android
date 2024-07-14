package com.example.dndhandbook.domain.models.class_detail

import com.example.dndhandbook.data.remote.dto.class_detail.ClassDetailDto
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.sub_race.LanguageOption
import com.google.gson.annotations.SerializedName

data class ClassDetail(
    val index: String = "",
    val name: String = "",
    val hitDie: Double = 0.0,
    val proficiencyChoices: List<LanguageOption> = emptyList(),
    val proficiencies: List<DefaultObject> = emptyList(),
    val savingThrows: List<DefaultObject> = emptyList(),
    val startingEquipment: List<Equipment> = emptyList(),
    val startingEquipmentOptions: List<LanguageOption> = emptyList(),
    val classLevels: String = "",
    val multiClassing: MultiClassing = MultiClassing(),
    val subclasses: List<DefaultObject> = emptyList(),
    val spellCasting: SpellCasting = SpellCasting(),
    val spells: String = "",
    val url: String = "",
)

fun ClassDetailDto.toClassDetail(): ClassDetail = ClassDetail(
    index = index,
    name = name,
    hitDie = hitDie,
    proficiencyChoices = proficiencyChoices,
    proficiencies = proficiencies,
    savingThrows = savingThrows,
    startingEquipment = startingEquipment,
    startingEquipmentOptions = startingEquipmentOptions,
    classLevels = classLevels,
    multiClassing = multiClassing,
    subclasses = subclasses,
    spellCasting = spellCasting,
    spells = spells,
    url = url,
)

data class Equipment(
    @SerializedName("equipment")
    val equipment: DefaultObject = DefaultObject(),
    @SerializedName("quantity")
    val quantity: Int = 0
)

data class MultiClassing(
    @SerializedName("prerequisites")
    val prerequisites: List<AbilityBonus> = emptyList(),
    @SerializedName("proficiencies")
    val proficiencies: List<DefaultObject> = emptyList()
)

data class SpellCasting(
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("spellcasting_ability")
    val spellCastingAbility: DefaultObject = DefaultObject(),
    @SerializedName("info")
    val info: List<SpellCastingInfo> = emptyList()
)

data class SpellCastingInfo(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("desc")
    val desc: List<String> = emptyList(),
)