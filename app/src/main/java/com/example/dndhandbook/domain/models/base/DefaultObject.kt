package com.example.dndhandbook.domain.models.base

import com.google.gson.annotations.SerializedName

data class DefaultObject(
    @SerializedName("index")
    val index: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
)