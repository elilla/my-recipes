package com.example.myrecipes

import android.app.Application
import com.example.myrecipes.ui.UIModule
import com.google.firebase.analytics.FirebaseAnalytics

class MyRecipesApplication: Application() {
    lateinit var injector: MyRecipesApplicationComponent
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        injector = DaggerMyRecipesApplicationComponent.builder().uIModule(UIModule(this)).build()
    }

    @Synchronized
    fun getFirebase(): FirebaseAnalytics {
        return firebaseAnalytics
    }
}