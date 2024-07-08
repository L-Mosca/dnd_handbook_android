package com.example.dndhandbook.domain.models

import com.example.dndhandbook.domain.models.base.DefaultObject

data class Character(
    var race: DefaultObject = DefaultObject(),
    var subRace: DefaultObject = DefaultObject()
)