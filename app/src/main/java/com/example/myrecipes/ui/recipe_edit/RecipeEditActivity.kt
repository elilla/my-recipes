package com.example.myrecipes.ui.recipe_edit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit.*
import javax.inject.Inject

class RecipeEditActivity : AppCompatActivity(), RecipeEditScreen {

    @Inject
    lateinit var recipeEditPresenter: RecipeEditPresenter
    lateinit var recipe: Recipe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        injector.inject(this)

        updateButton.setOnClickListener {
            recipeEditPresenter.updateRecipe(recipe)
        }
    }

    override fun onStart() {
        super.onStart()
        recipeEditPresenter.attachScreen(this)
        recipe = intent.extras.getSerializable(MainActivity.RECIPE) as Recipe

    }

    override fun onStop() {
        super.onStop()
        recipeEditPresenter.detachScreen()
    }

    override fun showRecipe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRecipe() {
        finish()
    }

}