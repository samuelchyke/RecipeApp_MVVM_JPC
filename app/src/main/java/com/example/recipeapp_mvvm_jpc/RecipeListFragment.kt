package com.example.recipeapp_mvvm_jpc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

//    private val recipeViewModel by lazy {
//        ViewModelProvider(requireActivity())[RecipeViewModel::class.java]
//    }

    // Share the same instance of a view model between fragments
//    private val recipeViewModel : RecipeViewModel by activityViewModels()

    // Tie view model to a specific fragment
    private val recipeViewModel : RecipeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                val result = recipeViewModel._recipe.value
                LazyColumn{
                    itemsIndexed(items = result){ _, recipe ->
                        Composables.RecipeCard(recipe = recipe, onClick = {})
                    }

                }
            }
        }
    }

}