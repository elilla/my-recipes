package com.example.myrecipes.test

import com.example.myrecipes.mock.MockNetworkModule
import com.example.myrecipes.model.Image
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.testInjector
import com.example.myrecipes.ui.main.MainPresenter
import com.example.myrecipes.ui.main.MainScreen
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testNewRecipe() {
        mainPresenter.addNewRecipe()
        verify(mainScreen).addNewRecipe()
    }

    @Test
    fun testOpenRecipe(){
        mainPresenter.openSelectedRecipe(1)
        verify(mainScreen).openSelectedRecipe(1)
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}