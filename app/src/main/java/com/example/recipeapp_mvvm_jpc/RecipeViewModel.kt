package com.example.recipeapp_mvvm_jpc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp_mvvm_jpc.model.RecipeResult
import com.example.recipeapp_mvvm_jpc.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
   private val networkRepository: NetworkRepository
) : ViewModel(){

   init {
       searchRecipes("pasta")
   }

   private val _recipe : MutableLiveData<Response<RecipeResult>> = MutableLiveData()
   val recipe : LiveData<Response<RecipeResult>> get() = _recipe

   private fun searchRecipes(name: String)= viewModelScope.launch{
         val response = networkRepository.getListOfRecipes(name)
         _recipe.postValue(response)
      }

}

