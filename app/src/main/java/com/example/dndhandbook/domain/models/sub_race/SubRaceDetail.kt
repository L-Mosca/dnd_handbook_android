package com.example.dndhandbook.domain.models.sub_race

import com.example.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.race.ProficiencyOption
import com.google.gson.annotations.SerializedName

data class SubRaceDetail(
    val index: String = "",
    val level: Int = 0,
    val name: String = "",
    val url: String = "",
    val desc: String = "",
    val race: DefaultObject = DefaultObject(),
    val abilityBonuses: List<AbilityBonus> = emptyList(),
    val startingProficiencies: List<DefaultObject> = emptyList(),
    val languages: List<Language> = emptyList(),
    val languageOptions: LanguageOption = LanguageOption(),
    val racialTraits: List<Language> = emptyList(),
)

fun SubRaceDetailDto.toSubRaceDetail(): SubRaceDetail =
    SubRaceDetail(
        index = index,
        level = level,
        name = name,
        url = url,
        desc = desc,
        race = race,
        abilityBonuses = abilityBonuses,
        startingProficiencies = startingProficiencies,
        languages = languages,
        languageOptions = languageOptions,
        racialTraits = racialTraits
    )

data class Language(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
)

data class LanguageOption(
    @SerializedName("choose")
    val choose: Int = 0,
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("from")
    val from: From = From(),
)

data class From(
    @SerializedName("option_set_type")
    val optionSetType: String = "",
    @SerializedName("options")
    val options: List<ProficiencyOption> = emptyList(),
    @SerializedName("type")
    val type: String = "",
)