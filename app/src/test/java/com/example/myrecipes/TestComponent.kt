package com.example.myrecipes

import com.example.myrecipes.interactor.InteractorModule
import com.example.myrecipes.mock.MockNetworkModule
import com.example.myrecipes.test.MainTest
import com.example.myrecipes.test.RecipeDetailsTest
import com.example.myrecipes.test.RecipeEditTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : MyRecipesApplicationComponent {
    fun inject(recipeEditTest: RecipeEditTest)
    fun inject(recipeDetailsTest: RecipeDetailsTest)
    fun inject(mainTest: MainTest)
}