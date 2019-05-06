package com.example.myrecipes.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    var image: Image? = null,
    @SerializedName("ingredients")
    var ingredients: MutableList<Ingredient>? = null,
    @SerializedName("description")
    var description: String? = null

)