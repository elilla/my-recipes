package com.example.myrecipes.model

import com.google.gson.annotations.SerializedName

class Ingredient(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("quantity")
    var quantity: Double? = null,
    @SerializedName ("unit")
    var unit: String? = null
)