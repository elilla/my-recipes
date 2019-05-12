package com.example.myrecipes.ui.main

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor) : Presenter<MainScreen>() {
    fun showAllRecipesList() {
        val allRecipes: List<Recipe> = recipesInteractor.getAllRecipes();
        screen?.showAllRecipes(allRecipes)
    }

    fun addNewRecipe() {
        screen?.addNewRecipe()
    }

    fun openSelectedRecipe(recipe: Recipe){

    }

}