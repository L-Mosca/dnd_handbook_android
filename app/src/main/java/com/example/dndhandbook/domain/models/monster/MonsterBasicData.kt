package com.example.dndhandbook.domain.models.monster

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonsterBasicData(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable