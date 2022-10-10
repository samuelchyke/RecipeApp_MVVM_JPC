package com.example.recipeapp_mvvm_jpc.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipe_table")
data class CacheRecipe(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val cooking_instructions: String,
    val date_added: String,
    val date_updated: String,
    val description: String,
    val featured_image: String?,
    val ingredients: String,
    val long_date_added: Int,
    val long_date_updated: Int,
    val publisher: String,
    val rating: Int,
    val source_url: String,
    val title: String
) : Parcelable

fun List<Recipe>.mapToCache() : List<CacheRecipe>{
    return this.map { recipe ->
        CacheRecipe(
            id = recipe.pk,
            cooking_instructions = recipe.cooking_instructions,
            date_added = recipe.date_added,
            date_updated = recipe.date_updated,
            description = recipe.description,
            featured_image = recipe.featured_image,
            ingredients = recipe.ingredients.toString(),
            long_date_added = recipe.long_date_added,
            long_date_updated = recipe.long_date_updated,
            publisher = recipe.publisher,
            rating = recipe.rating,
            source_url = recipe.source_url,
            title = recipe.title
        )
    }
}
