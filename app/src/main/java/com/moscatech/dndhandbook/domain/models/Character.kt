package com.moscatech.dndhandbook.domain.models

import com.moscatech.dndhandbook.domain.models.base.DefaultObject

data class Character(
    var race: DefaultObject = DefaultObject(),
    var subRace: DefaultObject = DefaultObject(),
    var selectedClass: DefaultObject = DefaultObject(),
)