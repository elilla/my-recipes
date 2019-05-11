package com.example.myrecipes

import com.example.myrecipes.interactor.InteractorModule
import com.example.myrecipes.network.NetworkModule
import com.example.myrecipes.ui.UIModule
import com.example.myrecipes.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UIModule::class, InteractorModule::class, NetworkModule::class])
interface MyRecipesApplicationComponent {
    fun inject(mainActivity: MainActivity)
}