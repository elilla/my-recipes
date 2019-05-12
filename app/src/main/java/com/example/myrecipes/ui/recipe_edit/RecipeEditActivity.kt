package com.example.myrecipes.ui.recipe_edit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ListView
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.main.MainActivity
import com.example.myrecipes.ui.utils.IngredientsViewAdapter
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
            recipe.title = findViewById<EditText>(R.id.titleText).text.toString()
            recipe.image.url = findViewById<EditText>(R.id.pictureText).text.toString()
            recipe.description = findViewById<EditText>(R.id.descriptionText).text.toString()
            recipeEditPresenter.updateRecipe(recipe)
        }

        addButton.setOnClickListener {
            var newIngredient: Ingredient = Ingredient()
            newIngredient.name = findViewById<EditText>(R.id.ingredientName).text.toString()
            newIngredient.unit = findViewById<EditText>(R.id.ingredientUnit).text.toString()
            newIngredient.quantity = findViewById<EditText>(R.id.ingredientQuantity).text.toString().toDouble()
            recipeEditPresenter.addIngredient(recipe, newIngredient)
        }

        ingredientsList = findViewById<ListView>(R.id.ingredientsEditListView)

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
        var adapter = IngredientsViewAdapter(this, recipe.ingredients)
        ingredientsList.adapter = adapter
    }

    override fun onStop() {
        super.onStop()
        recipeEditPresenter.detachScreen()
    }

    override fun updateIngredient(){
        var adapter = IngredientsViewAdapter(this, recipe.ingredients)
        ingredientsList.adapter = adapter
    }

    override fun updateRecipe() {
        val intent = Intent()
        setResult(1, intent)
        finish()
    }
}