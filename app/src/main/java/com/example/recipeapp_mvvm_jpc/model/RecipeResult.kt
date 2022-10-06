package com.example.recipeapp_mvvm_jpc.model

data class RecipeResult(
    val count: Int,
//    val next: Int,
//    val previous: Int,
    val results: List<Recipe>
)