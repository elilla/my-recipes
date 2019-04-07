package com.example.myrecipes.ui.recipe_edit

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class RecipeEditPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor) : Presenter<RecipeEditScreen>() {
    fun showRecipeEdit(){
        screen?.showRecipe()
    }
}