package com.example.myrecipes.test

import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.testInjector
import com.example.myrecipes.ui.recipe_details.RecipeDetailsPresenter
import com.example.myrecipes.ui.recipe_details.RecipeDetailsScreen
import com.example.myrecipes.ui.recipe_edit.RecipeEditPresenter
import com.example.myrecipes.ui.recipe_edit.RecipeEditScreen
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class RecipeDetailsTest {
    @Inject
    lateinit var recipeDetailsPresenter: RecipeDetailsPresenter
    private lateinit var detailsScreen: RecipeDetailsScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        detailsScreen= mock()
        recipeDetailsPresenter.attachScreen(detailsScreen)
    }

    @Test
    fun testEditRecipe() {
        recipeDetailsPresenter.editRecipe()
        verify(detailsScreen).editRecipe()
    }

    @Test
    fun testDeleteRecipe(){
        recipeDetailsPresenter.deleteRecipe(Recipe())
        verify(detailsScreen).deleteRecipe()
    }

    @After
    fun tearDown() {
        recipeDetailsPresenter.detachScreen()
    }
}