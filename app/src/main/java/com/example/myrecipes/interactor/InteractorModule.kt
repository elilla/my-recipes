package com.example.myrecipes.interactor

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.network.RecipeApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideRecipesInteractor(recipeApi: RecipeApi) = RecipesInteractor(recipeApi)
}