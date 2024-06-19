package com.example.dndhandbook.data.remote.dto.race

import com.example.dndhandbook.domain.models.race.AbilityBonus
import com.example.dndhandbook.domain.models.race.DefaultRaceObject
import com.example.dndhandbook.domain.models.race.StartingProficiencyOptions
import com.google.gson.annotations.SerializedName

data class RaceDetailDto(
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