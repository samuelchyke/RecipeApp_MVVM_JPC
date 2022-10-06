package com.example.recipeapp_mvvm_jpc.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

//    @Provides
//    @Singleton
//    fun providesRoomDb(@ApplicationContext appContext: Context): BeerDatabase =
//        Room.databaseBuilder(
//            appContext,
//            BeerDatabase::class.java,
//            "beer-db"
//        ).build()
//
//    @Provides
//    @Singleton
//    fun providesCocktailDAO(database: BeerDatabase): BeerDAO =
//        database.beersDAO()
}