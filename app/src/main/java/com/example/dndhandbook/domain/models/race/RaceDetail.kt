package com.example.dndhandbook.domain.models.race

import com.example.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.google.gson.annotations.SerializedName

data class RaceDetail(
    @SerializedName("ability_bonuses")
    val abilityBonuses: List<AbilityBonus> = emptyList(),
    @SerializedName("age")
    val age: String = "",
    @SerializedName("alignment")
    val alignment: String = "",
    @SerializedName("index")
    val index: String = "",
    @SerializedName("language_desc")
    val languageDescription: String = "",
    @SerializedName("languages")
    val languages: List<DefaultRaceObject> = emptyList(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("size")
    val size: String = "",
    @SerializedName("size_description")
    val sizeDescription: String = "",
    @SerializedName("speed")
    val speed: Int = 0,
    @SerializedName("starting_proficiencies")
    val startingProficiencies: List<DefaultRaceObject> = emptyList(),
    @SerializedName("starting_proficiency_options")
    val startingProficiencyOptions: StartingProficiencyOptions = StartingProficiencyOptions(),
    @SerializedName("subraces")
    val subRaces: List<DefaultRaceObject> = emptyList(),
    @SerializedName("traits")
    val traits: List<DefaultRaceObject> = emptyList(),
    @SerializedName("url")
    val url: String = "",
)

fun RaceDetailDto.toRaceDetail(): RaceDetail = RaceDetail(
    abilityBonuses = abilityBonuses,
    age = age,
    alignment = alignment,
    index = index,
    languageDescription = languageDescription,
    languages = languages,
    name = name,
    size = size,
    sizeDescription = sizeDescription,
    speed = speed,
    startingProficiencies = startingProficiencies,
    startingProficiencyOptions = startingProficiencyOptions,
    subRaces = subRaces,
    traits = traits,
    url = url
)

data class DefaultRaceObject(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
)

data class AbilityBonus(
    @SerializedName("ability_score")
    val abilityScore: DefaultRaceObject = DefaultRaceObject(),
    @SerializedName("")
    val bonus: Int = 0,
)

data class StartingProficiencyOptions(
    @SerializedName("choose")
    val choose: Int = 0,
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("from")
    val proficiencyDetail: ProficiencyDetail = ProficiencyDetail(),
    @SerializedName("type")
    val type: String = ""
)

data class ProficiencyDetail(
    @SerializedName("option_set_type")
    val optionSetType: String = "",
    @SerializedName("options")
    val proficiencyOptions: List<ProficiencyOption> = emptyList()
)

data class ProficiencyOption(
    @SerializedName("item")
    val item: DefaultRaceObject = DefaultRaceObject(),
    @SerializedName("option_type")
    val optionType: String = ""
)