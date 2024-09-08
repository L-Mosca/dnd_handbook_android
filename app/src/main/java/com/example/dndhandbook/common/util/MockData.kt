package com.example.dndhandbook.common.util

import com.example.dndhandbook.domain.models.base.DefaultObject
import com.example.dndhandbook.domain.models.class_detail.ClassDetail
import com.example.dndhandbook.domain.models.class_detail.Equipment
import com.example.dndhandbook.domain.models.race.ProficiencyOption
import com.example.dndhandbook.domain.models.sub_race.From
import com.example.dndhandbook.domain.models.sub_race.LanguageOption

class MockData {
    companion object {
        fun getClassDetail(): ClassDetail {
            val proficienciesOptions = mutableListOf<LanguageOption>()
            val proficiencies = mutableListOf<DefaultObject>()
            val options = mutableListOf<ProficiencyOption>()
            val savingThrows = mutableListOf<DefaultObject>()
            val startingEquipment = mutableListOf<Equipment>()

            for (i in 1..6) {
                options.add(ProficiencyOption(item = DefaultObject(name = "Skill: Animal Handling")))
                proficiencies.add(DefaultObject(name = "Light Armor"))
                savingThrows.add(DefaultObject(name = "STR"))
                startingEquipment.add(element = Equipment(equipment = DefaultObject(name = "Explorer's Pack")))
            }

            proficienciesOptions.add(
                LanguageOption(
                    desc = "Choose two from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival",
                    from = From(optionSetType = "option_array", options = options)
                )
            )

            val mockData = ClassDetail(
                index = "barbarian",
                name = "Barbarian",
                hitDie = 12.0,
                proficiencyChoices = proficienciesOptions,
                proficiencies = proficiencies,
                savingThrows = savingThrows,
                startingEquipment = startingEquipment,
                startingEquipmentOptions = proficienciesOptions,
                subclasses = savingThrows,
            )
            return mockData
        }
    }
}