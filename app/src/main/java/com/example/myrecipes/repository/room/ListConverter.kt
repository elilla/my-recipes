package com.example.myrecipes.repository.room

import android.arch.persistence.room.TypeConverter
import com.example.myrecipes.model.Ingredient
import com.google.gson.reflect.TypeToken
import java.util.Collections.emptyList
import com.google.gson.Gson
import java.util.*


class ListConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToIngredients(data: String?): MutableList<Ingredient> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<MutableList<Ingredient>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Ingredient>): String {
        return gson.toJson(someObjects)
    }
}
