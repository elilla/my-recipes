package com.example.myrecipes.repository.room

/**
 * Created by Acer on 2019. 05. 06..
 */

import android.arch.persistence.room.Room
import android.content.Context
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.repository.Repository
import javax.inject.Inject

class RoomRepository @Inject constructor() : Repository {
    private lateinit var recipeDao: RecipeDao

    override fun open(context: Context) {
        recipeDao = Room.databaseBuilder(context, MyDatabase::class.java, "stuffs.db").build().roomDao()
    }

    override fun close() {
        // Empty
    }
    override fun getRecipes(): List<Recipe> {
        return recipeDao.getRecipes()
    }

    override fun saveRecipe(recipe: Recipe) {
        return recipeDao.saveRecipe(recipe)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRecipes(recipes: List<Recipe>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeRecipes(recipe: Recipe) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}