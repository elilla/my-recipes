package com.example.myrecipes.repository

/**
 * Created by Acer on 2019. 05. 06..
 */
import android.content.Context
import com.example.myrecipes.model.Recipe


interface Repository {

    fun getRecipes(): List<Recipe>

    fun open(context: Context)

    fun close()

    fun saveRecipe(recipe: Recipe)

    fun updateRecipes(recipes: List<Recipe>)

    fun removeRecipes(recipe: Recipe)

}