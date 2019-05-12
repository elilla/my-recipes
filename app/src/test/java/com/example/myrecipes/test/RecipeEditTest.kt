package com.example.myrecipes.test

import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.testInjector
import com.example.myrecipes.ui.recipe_edit.RecipeEditActivity
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
class RecipeEditTest {
    @Inject
    lateinit var recipeEditPresenter: RecipeEditPresenter
    private lateinit var editScreen: RecipeEditScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        editScreen= mock()
        recipeEditPresenter.attachScreen(editScreen)
    }

    @Test
    fun testUpdateIngredient() {
        recipeEditPresenter.addIngredient(Recipe(), Ingredient())
        verify(editScreen).updateIngredient()
    }

    @Test
    fun testOpenRecipe(){
        recipeEditPresenter.updateRecipe(Recipe())
        verify(editScreen).updateRecipe()
    }

    @After
    fun tearDown() {
        recipeEditPresenter.detachScreen()
    }
}