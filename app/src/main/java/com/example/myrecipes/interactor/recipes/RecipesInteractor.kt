package com.example.myrecipes.interactor.recipes

import android.util.Log
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.network.RecipeApi
import javax.inject.Inject

class RecipesInteractor @Inject constructor(private var recipeApi: RecipeApi)  {

    fun getAllRecipes() {
        try {
            val recipeQuery = recipeApi.getAllRecipes()
            val response = recipeQuery.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {
            Log.d(e.toString(),  "error in get all recipes");
        }
    }

    fun createRecipe(newRecipe: Recipe) {
        try {
            val recipeQuery = recipeApi.createRecipe(newRecipe)
            val response = recipeQuery.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {
            Log.d(e.toString(),  "error in create new recipe");
        }
    }

    fun updateRecipe(updatedRecipe: Recipe) {
        try {
            val recipeQuery = recipeApi.updateRecipe(updatedRecipe.id, updatedRecipe)
            val response = recipeQuery.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {
            Log.d(e.toString(),  "error in update recipe");
        }
    }

    fun deleteRecipe(recipe: Recipe) {
        try {
            val recipeQuery = recipeApi.deleteRecipe(recipe.id)
            val response = recipeQuery.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        } catch (e: Exception) {
            Log.d(e.toString(),  "error in delete recipe");
        }
    }
}