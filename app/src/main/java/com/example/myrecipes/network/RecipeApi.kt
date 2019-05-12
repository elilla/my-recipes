package com.example.myrecipes.network

import com.example.myrecipes.model.Recipe
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RecipeApi {
    @GET("Recipe")
    fun getAllRecipes(): Call<List<Recipe>>

    @GET("Recipe/{recipeId}")
    fun getRecipeById(): Call<Recipe>

    @POST("Recipe")
    fun createRecipe(@Body recipe: Recipe): Call<ResponseBody>

    @PUT("Recipe/{recipeId}")
    fun updateRecipe(@Path("recipeId") id: Long?, @Body recipe: Recipe): Call<ResponseBody>

    @DELETE("Recipe/{recipeId}")
    fun deleteRecipe(@Path("recipeId") id: Long?): Call<ResponseBody>
}