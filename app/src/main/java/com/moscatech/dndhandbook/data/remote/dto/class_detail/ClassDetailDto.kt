package com.moscatech.dndhandbook.data.remote.dto.class_detail

import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.class_detail.Equipment
import com.moscatech.dndhandbook.domain.models.class_detail.MultiClassing
import com.moscatech.dndhandbook.domain.models.class_detail.SpellCasting
import com.moscatech.dndhandbook.domain.models.sub_race.LanguageOption
import com.google.gson.annotations.SerializedName


data class ClassDetailDto(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("hit_die")
    val hitDie: Double = 0.0,
    @SerializedName("proficiency_choices")
    val proficiencyChoices: List<LanguageOption> = emptyList(),
    @SerializedName("proficiencies")
    val proficiencies: List<DefaultObject> = emptyList(),
    @SerializedName("saving_throws")
    val savingThrows: List<DefaultObject> = emptyList(),
    @SerializedName("starting_equipment")
    val startingEquipment: List<Equipment> = emptyList(),
    @SerializedName("starting_equipment_options")
    val startingEquipmentOptions: List<LanguageOption> = emptyList(),
    @SerializedName("class_levels")
    val classLevels: String = "",
    @SerializedName("multi_classing")
    val multiClassing: MultiClassing = MultiClassing(),
    @SerializedName("subclasses")
    val subclasses: List<DefaultObject> = emptyList(),
    @SerializedName("spellcasting")
    val spellCasting: SpellCasting = SpellCasting(),
    @SerializedName("spells")
    val spells: String = "",
    @SerializedName("url")
    val url: String = "",
)
