package com.moscatech.dndhandbook.domain.models.sub_race

import com.moscatech.dndhandbook.data.remote.dto.sub_race.SubRaceDetailDto
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.base.DefaultProficiencyObject
import com.moscatech.dndhandbook.domain.models.race.AbilityBonus
import com.moscatech.dndhandbook.domain.models.race.ProficiencyOption
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
    val languages: List<DefaultProficiencyObject> = emptyList(),
    val languageOptions: LanguageOption = LanguageOption(),
    val racialTraits: List<DefaultProficiencyObject> = emptyList(),
) {

    fun getMockData(): SubRaceDetail {
        return SubRaceDetail(
            name = "Half-Elf",
            desc = "Versatile and adaptable, half-elves are a mix of elf and human.",
            race = DefaultObject(name = "Elf"),
            abilityBonuses = listOf(
                AbilityBonus(abilityScore = DefaultObject(index = "CHA")),
                AbilityBonus(abilityScore = DefaultObject(index = "DEX"))
            ),
            startingProficiencies = listOf(DefaultObject(name = "Perception")),
            languages = listOf(
                DefaultProficiencyObject(name = "Common"),
                DefaultProficiencyObject(name = "Elvish")
            ),
            languageOptions = LanguageOption(
                desc = "Choose one additional language",
                from = From(options = listOf(ProficiencyOption(item = DefaultObject(name = "Dwarvish"))))
            ),
            racialTraits = listOf(
                DefaultProficiencyObject(name = "Darkvision"),
                DefaultProficiencyObject(name = "Fey Ancestry")
            )
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

fun List<DefaultProficiencyObject>.toDefaultRaceObject(): List<DefaultObject> {
    val list = mutableListOf<DefaultObject>()
    this.forEach {
        list.add(DefaultObject(index = it.index, name = it.name, url = it.url))
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