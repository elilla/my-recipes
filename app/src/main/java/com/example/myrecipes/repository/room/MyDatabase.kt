package com.example.myrecipes.repository.room

/**
 * Created by Acer on 2019. 05. 06..
 */
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.myrecipes.model.Recipe

@Database(
    entities = [Recipe::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class MyDatabase : RoomDatabase() {

    abstract fun roomDao(): RecipeDao

}