package com.example.myrecipes

import com.example.myrecipes.interactor.InteractorModule
import com.example.myrecipes.mock.MockNetworkModule
import com.example.myrecipes.network.NetworkModule
import com.example.myrecipes.ui.UIModule
import com.example.myrecipes.ui.main.MainActivity
import com.example.myrecipes.ui.recipe_details.RecipeDetailsActivity
import com.example.myrecipes.ui.recipe_edit.RecipeEditActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, MockNetworkModule::class])
interface MyRecipesApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(recipeDetailsActivity: RecipeDetailsActivity)
    fun inject(recipeEditActivity: RecipeEditActivity)
}