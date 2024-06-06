package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterBasicData (
    val index: String = "",
    val name: String = "",
    val image: String = ""
): Parcelable