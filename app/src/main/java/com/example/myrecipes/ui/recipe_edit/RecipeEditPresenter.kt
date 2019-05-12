package com.example.myrecipes.ui.recipe_edit

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class RecipeEditPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor) :
    Presenter<RecipeEditScreen>() {
    fun showRecipeEdit() {
        screen?.showRecipe()
    }

    fun updateRecipe(recipe: Recipe) {
        if (recipe.id != null) {
            recipesInteractor.updateRecipe(recipe)
        } else {
            recipesInteractor.createRecipe(recipe)
        }
        screen?.updateRecipe()
    }

    fun addIngredient(recipe: Recipe, ingredient: Ingredient) {
        recipe.ingredients.add(ingredient)
        screen?.updateIngredient()
    }
}