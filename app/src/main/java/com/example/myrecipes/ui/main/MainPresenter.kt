package com.example.myrecipes.ui.main

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.ui.Presenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val recipesInteractor: RecipesInteractor) : Presenter<MainScreen>() {
    fun showAllRecipesList() {
        screen?.showAllRecipes()
    }
}