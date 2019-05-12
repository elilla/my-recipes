package com.example.myrecipes.ui.recipe_details

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.main.MainActivity
import com.example.myrecipes.ui.main.MainActivity.Companion.RECIPE
import com.example.myrecipes.ui.recipe_edit.RecipeEditActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*
import javax.inject.Inject

class RecipeDetailsActivity: AppCompatActivity(), RecipeDetailsScreen {

    @Inject
    lateinit var recipeDetailsPresenter: RecipeDetailsPresenter
    lateinit var recipe: Recipe
    var gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        injector.inject(this)

        editButton.setOnClickListener{
            recipeDetailsPresenter.editRecipe()
        }

        deleteButton.setOnClickListener{
            recipeDetailsPresenter.deleteRecipe(recipe)
        }
    }
    override fun onStart() {
        super.onStart()
        recipeDetailsPresenter.attachScreen(this)
        recipe = intent.extras.getSerializable(RECIPE) as Recipe
    }

    override fun onStop() {
        super.onStop()
        recipeDetailsPresenter.detachScreen()
    }

    override fun showRecipe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editRecipe() {
        val intent = Intent(this, RecipeEditActivity::class.java)
        intent.putExtra(RECIPE, recipe)
        startActivity(intent)
    }

    override fun deleteRecipe() {
        finish()
    }

}
