package com.example.myrecipes.ui.recipe_details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class RecipeDetailsActivity: AppCompatActivity(), RecipeDetailsScreen {

    @Inject
    lateinit var recipeDetailsPresenter: RecipeDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        recipeDetailsPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        recipeDetailsPresenter.detachScreen()
    }

    override fun showRecipe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
