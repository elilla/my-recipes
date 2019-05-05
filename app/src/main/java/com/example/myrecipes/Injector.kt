package com.example.myrecipes

import android.app.Activity

val Activity.injector: MyRecipesApplicationComponent
    get() {
        return (this.applicationContext as MyRecipesApplication).injector
    }
