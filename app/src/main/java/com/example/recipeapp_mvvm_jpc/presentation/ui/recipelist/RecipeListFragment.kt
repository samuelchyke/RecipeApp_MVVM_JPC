package com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.activityViewModels
import com.example.recipeapp_mvvm_jpc.presentation.Composables
import com.example.recipeapp_mvvm_jpc.presentation.Composables.FoodCategoryChip
import com.example.recipeapp_mvvm_jpc.presentation.Composables.SearchAppBar
import com.example.recipeapp_mvvm_jpc.presentation.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val recipeViewModel : RecipeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                val result = recipeViewModel.recipe.value
                val query = recipeViewModel.query.value
                val selectedCategory = recipeViewModel.selectedCategory.value
                val selectedChip = recipeViewModel.scrollTabPosition.value
                val focusManager = LocalFocusManager.current
                Column {
                    SearchAppBar(
                        query = query,
                        selectedCategory = selectedCategory,
                        selectedChip = selectedChip ,
                        onQueryChanged = recipeViewModel::onQueryChanged,
                        onExecuteSearch = recipeViewModel::searchRecipes,
                        clearFocus = focusManager::clearFocus,
                        onClearSelectedCategory = recipeViewModel::onClearSelectedCategory,
                        onSelectedCategoryChanged = recipeViewModel::onSelectedCategoryChanged
                    )
                    LazyColumn{
                        itemsIndexed(items = result){ _, recipe ->
                            Composables.RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }
            }
        }
    }
}

