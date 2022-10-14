package com.example.recipeapp_mvvm_jpc.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp_mvvm_jpc.model.Recipe
import com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist.FoodCategory
import com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist.getFoodCategory
import com.example.recipeapp_mvvm_jpc.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    val recipe: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)

    val query = mutableStateOf("")

    init {
        searchRecipes()
    }

    fun searchRecipes() = viewModelScope.launch {
        val response = networkRepository.getListOfRecipes(query.value)
        response.body()?.let {
            recipe.value = it.results
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

    fun onSelectedCategoryChanged(category: String) {
        val newCategory = getFoodCategory(category)
        this.selectedCategory.value = newCategory
        onQueryChanged(category)
    }

    fun onClearSelectedCategory() {
        this.selectedCategory.value = null
    }

}

