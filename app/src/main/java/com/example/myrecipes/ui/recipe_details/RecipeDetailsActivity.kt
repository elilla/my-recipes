package com.example.myrecipes.ui.recipe_details

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myrecipes.R
import com.example.myrecipes.injector
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.ui.main.MainActivity.Companion.RECIPE
import com.example.myrecipes.ui.recipe_edit.RecipeEditActivity
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.net.URL
import android.os.StrictMode
import android.widget.ListView
import android.widget.TextView
import com.example.myrecipes.ui.utils.IngredientsAdapter


class RecipeDetailsActivity: AppCompatActivity(), RecipeDetailsScreen {

    @Inject
    lateinit var recipeDetailsPresenter: RecipeDetailsPresenter
    lateinit var recipe: Recipe
    lateinit var ingredientsListView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        injector.inject(this)
        ingredientsListView = findViewById<ListView>(R.id.ingredientsListView)

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
        setViewData()
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

    private fun setViewData(){
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build()

            StrictMode.setThreadPolicy(policy)
        }
        val newurl = URL(recipe.image.url)
        val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
        findViewById<ImageView>(R.id.imageView).setImageBitmap(mIcon_val)
        findViewById<TextView>(R.id.recipeTitle).setText(recipe.title)
        findViewById<TextView>(R.id.descriptionText).setText(recipe.description)

        val adapter = IngredientsAdapter(this, recipe.ingredients)
        ingredientsListView.adapter = adapter
    }

}
