package com.example.myrecipes.ui.recipe_edit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_edit.*
import javax.inject.Inject

class RecipeEditActivity : AppCompatActivity(), RecipeEditScreen {

    @Inject
    lateinit var recipeEditPresenter: RecipeEditPresenter
    var recipe: Recipe = Recipe()
    private lateinit var ingredientsList: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        injector.inject(this)

        saveButton.setOnClickListener {
            recipeEditPresenter.updateRecipe(recipe)
        }

        ingredientsList = findViewById<ListView>(R.id.ingredientsList)

    }

    override fun onStart() {
        super.onStart()
        recipeEditPresenter.attachScreen(this)
        if (intent.extras != null) {
            recipe = intent.extras.getSerializable(MainActivity.RECIPE) as Recipe
        }
        findViewById<EditText>(R.id.titleText).setText(recipe.title)
        findViewById<EditText>(R.id.pictureText).setText(recipe.image.url)
        findViewById<EditText>(R.id.descriptionText).setText(recipe.description)
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