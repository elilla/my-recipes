package com.example.myrecipes.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.recipe_details.RecipeDetailsActivity
import com.example.myrecipes.ui.recipe_edit.RecipeEditActivity
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var listView: ListView
    var recipeList: List<Recipe> = listOf()
    var gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        fab.setOnClickListener { mainPresenter.addNewRecipe() }

        listView = findViewById<ListView>(R.id.recipe_list_view)


    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
        mainPresenter.showAllRecipesList()

    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }


    override fun showAllRecipes(recipes: List<Recipe>) {
        recipeList = recipes
        val listItems = arrayOfNulls<String>(recipeList.size)
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            openSelectedRecipe(position)
        }

    }

    override fun addNewRecipe() {
        val intent = Intent(this, RecipeEditActivity::class.java)
        startActivity(intent)
    }

    override fun openSelectedRecipe(position: Int) {
        val intent = Intent(this, RecipeDetailsActivity::class.java)
        intent.putExtra(RECIPE, recipeList.get(position))
        startActivity(intent)
    }

    companion object {
        const val RECIPE = "RECIPE"
    }
}
