package com.example.dndhandbook.domain.models

import com.example.dndhandbook.domain.models.race.RaceBasicData

data class Character(
    var race: RaceBasicData = RaceBasicData()
)