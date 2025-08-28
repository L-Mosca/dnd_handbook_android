package com.moscatech.dndhandbook.domain.models.base

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DefaultProficiencyObject(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("level")
    val level: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
) : Parcelable