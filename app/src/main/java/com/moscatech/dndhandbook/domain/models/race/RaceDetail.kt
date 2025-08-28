package com.moscatech.dndhandbook.domain.models.race

import com.moscatech.dndhandbook.data.remote.dto.race.RaceDetailDto
import com.moscatech.dndhandbook.domain.models.base.DefaultObject
import com.moscatech.dndhandbook.domain.models.sub_race.From
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
    val languages: List<DefaultObject> = emptyList(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("size")
    val size: String = "",
    @SerializedName("size_description")
    val sizeDescription: String = "",
    @SerializedName("speed")
    val speed: Int = 0,
    @SerializedName("starting_proficiencies")
    val startingProficiencies: List<DefaultObject> = emptyList(),
    @SerializedName("starting_proficiency_options")
    val startingProficiencyOptions: StartingProficiencyOptions = StartingProficiencyOptions(),
    @SerializedName("subraces")
    val subRaces: List<DefaultObject> = emptyList(),
    @SerializedName("traits")
    val traits: List<DefaultObject> = emptyList(),
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

data class AbilityBonus(
    @SerializedName("ability_score")
    val abilityScore: DefaultObject = DefaultObject(),
    @SerializedName("bonus")
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
    val item: DefaultObject = DefaultObject(),
    @SerializedName("option_type")
    val optionType: String = "",
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("of")
    val of: DefaultObject = DefaultObject(),
    @SerializedName("choice")
    val choice: Choice = Choice()

)

data class Choice(
    @SerializedName("desc")
    val desc: String = "",
    @SerializedName("choose")
    val choose: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("from")
    val from: From = From(),
)