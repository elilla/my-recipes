package com.example.myrecipes.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.myrecipes.repository.room.ListConverter
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
    var image: Image? = null,
    @SerializedName("ingredients")
    var ingredients: MutableList<Ingredient>? = null,
    @SerializedName("description")
    var description: String? = null
) :Serializable