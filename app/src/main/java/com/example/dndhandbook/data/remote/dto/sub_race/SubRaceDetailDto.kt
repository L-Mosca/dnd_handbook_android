package com.example.dndhandbook.data.remote.dto.sub_race

import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.base.DefaultProficiencyObject
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.sub_race.LanguageOption
import com.google.gson.annotations.SerializedName

data class SubRaceDetailDto(
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
    @SerializedName("race")
    val race: DefaultObject = DefaultObject(),
    @SerializedName("ability_bonuses")
    val abilityBonuses: List<AbilityBonus> = emptyList(),
    @SerializedName("starting_proficiencies")
    val startingProficiencies: List<DefaultObject> = emptyList(),
    @SerializedName("languages")
    val languages: List<DefaultProficiencyObject> = emptyList(),
    @SerializedName("language_options")
    val languageOptions: LanguageOption = LanguageOption(),
    @SerializedName("racial_traits")
    val racialTraits: List<DefaultProficiencyObject> = emptyList(),
)