package com.example.myrecipes

import android.app.Application
import com.example.myrecipes.ui.UIModule

class MyRecipesApplication: Application() {
    lateinit var injector: MyRecipesApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMyRecipesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}