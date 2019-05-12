package com.example.myrecipes

import android.content.Context
import com.example.myrecipes.interactor.recipes.RecipesInteractor
import com.example.myrecipes.ui.main.MainPresenter
import com.example.myrecipes.ui.recipe_edit.RecipeEditPresenter
import com.example.myrecipes.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(recipesInteractor: RecipesInteractor) = MainPresenter(recipesInteractor)

    @Provides
    @Singleton
    fun provideRecipeEditPresenter(recipesInteractor: RecipesInteractor) = RecipeEditPresenter(recipesInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}