package com.example.myrecipes.repository.room

/**
 * Created by Acer on 2019. 05. 06..
 */

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.myrecipes.model.Recipe

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipes")
    fun getRecipes(): List<Recipe>

    @Insert
    fun saveRecipe(recipe: Recipe)

    @Update
    fun updateRecipes(recipes: List<Recipe>)

    @Delete
    fun removeRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipes WHERE id = :id")
    fun findRecipeById(id: String): Recipe?

}