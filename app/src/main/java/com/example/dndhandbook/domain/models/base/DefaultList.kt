package com.example.dndhandbook.domain.models.base

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DefaultList (
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<DefaultObject> = emptyList(),
): Parcelable