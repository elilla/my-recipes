package com.example.myrecipes.interactor

import com.example.myrecipes.interactor.recipes.RecipesInteractor
import dagger.Provides
import javax.inject.Singleton

class InteractorModule {
    @Provides
    @Singleton
    fun provideRecipesInteractor() = RecipesInteractor()
}