package com.example.myrecipes.ui.recipe_details

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class RecipeDetailsPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor): Presenter<RecipeDetailsScreen>() {
    fun showRecipeDetails(){
        screen?.showRecipe()
    }

    fun editRecipe(){
        screen?.editRecipe()
    }

    fun deleteRecipe(recipe: Recipe) {
        recipesInteractor.deleteRecipe(recipe)
        screen?.deleteRecipe()
    }
}