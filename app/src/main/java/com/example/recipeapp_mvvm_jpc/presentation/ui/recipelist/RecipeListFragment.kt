package com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.recipeapp_mvvm_jpc.presentation.Composables
import com.example.recipeapp_mvvm_jpc.presentation.Composables.CircularIndeterminateProgressBar
import com.example.recipeapp_mvvm_jpc.presentation.Composables.RecipeList
import com.example.recipeapp_mvvm_jpc.presentation.Composables.SearchAppBar
import com.example.recipeapp_mvvm_jpc.presentation.PAGE_SIZE
import com.example.recipeapp_mvvm_jpc.presentation.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val recipeViewModel: RecipeViewModel by activityViewModels()

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
                val loading = recipeViewModel.loading.value
                val page = recipeViewModel.page.value
                val focusManager = LocalFocusManager.current

                Scaffold(
                    topBar = {
                        SearchAppBar(
                            query = query,
                            selectedCategory = selectedCategory,
                            selectedChip = selectedChip,
                            onQueryChanged = recipeViewModel::onQueryChanged,
                            onExecuteSearch = recipeViewModel::searchRecipes,
                            clearFocus = focusManager::clearFocus,
                            onClearSelectedCategory = recipeViewModel::clearSelectedCategory,
                            onSelectedCategoryChanged = recipeViewModel::onSelectedCategoryChanged
                        )
                    }
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(it)
                    ) {
                        RecipeList(
                            loading = loading,
                            recipes = result,
                            onChangeScrollPosition = recipeViewModel::onChangedRecipeResultPosition,
                            page = page,
                            onTriggerNextPage = { recipeViewModel.nextPage() },
                            navController = findNavController()
                        )
                    }
                }
            }
        }
    }
}

