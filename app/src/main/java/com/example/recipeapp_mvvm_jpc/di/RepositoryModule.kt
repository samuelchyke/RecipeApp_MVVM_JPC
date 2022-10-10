package com.example.recipeapp_mvvm_jpc.di

import com.example.recipeapp_mvvm_jpc.repository.NetworkRepository
import com.example.recipeapp_mvvm_jpc.repository.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository

//    @Binds
//    @ViewModelScoped
//    abstract fun provideCacheRepository(cacheRepositoryImpl: CacheRepositoryImpl): CacheRepository


}