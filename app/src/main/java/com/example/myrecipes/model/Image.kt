package com.example.myrecipes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Image(
    @SerializedName("url")
    var url: String? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("width")
    var width: Int? = null
): Serializable