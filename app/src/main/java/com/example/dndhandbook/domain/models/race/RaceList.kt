package com.example.dndhandbook.domain.models.race

import android.os.Parcelable
import com.example.dndhandbook.data.remote.dto.RaceListDto
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class RaceList(
    val count: Int = 0,
    val results: List<RaceBasicData> = emptyList()
)

fun RaceListDto.toRaceList(): RaceList = RaceList(count = count, results = results)

@Parcelize
data class RaceBasicData(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable
