package com.example.myrecipes.ui.recipe_details

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class RecipeDetailsPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor): Presenter<RecipeDetailsScreen>() {
    fun showRecipeDetails(){
        screen?.showRecipe()
    }
}