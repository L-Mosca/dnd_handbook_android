package com.example.dndhandbook.data.remote.dto.monster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterBasicDataDto(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable