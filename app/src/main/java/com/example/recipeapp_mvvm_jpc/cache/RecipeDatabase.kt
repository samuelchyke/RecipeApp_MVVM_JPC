package com.example.recipeapp_mvvm_jpc.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recipeapp_mvvm_jpc.model.CacheRecipe

@Database(entities = [
    CacheRecipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDAO() : RecipeDAO

}
