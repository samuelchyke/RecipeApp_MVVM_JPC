package com.example.recipeapp_mvvm_jpc.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp_mvvm_jpc.model.Recipe
import com.example.recipeapp_mvvm_jpc.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    val recipe: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query = mutableStateOf("")

    val chip = mutableStateOf(0)

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

    fun onChipSelected(chip: Int) {
        this.chip.value = chip
    }

}

