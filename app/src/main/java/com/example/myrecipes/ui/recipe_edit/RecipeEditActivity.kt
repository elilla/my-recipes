package com.example.myrecipes.ui.recipe_edit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class RecipeEditActivity: AppCompatActivity(), RecipeEditScreen {
    @Inject
    lateinit var recipeEditPresenter: RecipeEditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        recipeEditPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        recipeEditPresenter.detachScreen()
    }

}