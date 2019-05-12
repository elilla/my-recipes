package com.example.myrecipes.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "recipes")
class Recipe constructor(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("image")
    @Embedded
    var image: Image = Image(),
    @SerializedName("ingredients")
    var ingredients: MutableList<Ingredient> = mutableListOf<Ingredient>(Ingredient("",0.0,"")),
    @SerializedName("description")
    var description: String? = null
) :Serializable