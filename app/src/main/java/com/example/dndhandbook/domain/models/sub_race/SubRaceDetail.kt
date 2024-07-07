package com.example.dndhandbook.domain.models.sub_race

import com.example.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.race.DefaultRaceObject
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
) {

    fun getMockData(): SubRaceDetail {
        return SubRaceDetail(
            name = "Half-Elf",
            desc = "Versatile and adaptable, half-elves are a mix of elf and human.",
            race = DefaultObject(name = "Elf"),
            abilityBonuses = listOf(
                AbilityBonus(abilityScore = DefaultRaceObject(index = "CHA")),
                AbilityBonus(abilityScore = DefaultRaceObject(index = "DEX"))
            ),
            startingProficiencies = listOf(DefaultObject(name = "Perception")),
            languages = listOf(Language(name = "Common"), Language(name = "Elvish")),
            languageOptions = LanguageOption(
                desc = "Choose one additional language",
                from = From(options = listOf(ProficiencyOption(item = DefaultRaceObject(name = "Dwarvish"))))
            ),
            racialTraits = listOf(Language(name = "Darkvision"), Language(name = "Fey Ancestry"))
        )
    }
}

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

fun List<Language>.toDefaultRaceObject(): List<DefaultRaceObject> {
    val list = mutableListOf<DefaultRaceObject>()
    this.forEach {
        list.add(DefaultRaceObject(index = it.index, name = it.name, url = it.url))
    }
    return list
}

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