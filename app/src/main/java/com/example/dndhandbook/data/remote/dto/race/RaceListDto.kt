package com.example.dndhandbook.data.remote.dto.race

import android.os.Parcelable
import com.example.dndhandbook.domain.models.race.RaceBasicData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RaceListDto(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<RaceBasicData> = emptyList()
) : Parcelable