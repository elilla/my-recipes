package com.example.myrecipes.ui.main

import com.example.myrecipes.model.Recipe
import java.text.FieldPosition

interface MainScreen {
    fun showAllRecipes(allRecipes: List<Recipe>)
    fun addNewRecipe()
    fun openSelectedRecipe(position: Int)

}