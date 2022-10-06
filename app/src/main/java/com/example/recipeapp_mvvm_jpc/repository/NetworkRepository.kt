package com.example.recipeapp_mvvm_jpc.repository

import com.example.recipeapp_mvvm_jpc.model.Recipe
import com.example.recipeapp_mvvm_jpc.model.RecipeResult
import com.example.recipeapp_mvvm_jpc.network.RecipeServiceApi
import retrofit2.Response
import javax.inject.Inject

interface NetworkRepository {

    suspend fun getListOfRecipes(query: String) : Response<RecipeResult>

    suspend fun getRecipe(id : Int) : Response<Recipe>

}

class NetworkRepositoryImpl @Inject constructor(
    private val recipeServiceApi: RecipeServiceApi
):NetworkRepository{

    override suspend fun getListOfRecipes(query: String): Response<RecipeResult> {
        return recipeServiceApi.getListOfRecipes(query =  query)
    }

    override suspend fun getRecipe(id: Int): Response<Recipe> {
        return recipeServiceApi.getRecipe(id = id)
    }

}