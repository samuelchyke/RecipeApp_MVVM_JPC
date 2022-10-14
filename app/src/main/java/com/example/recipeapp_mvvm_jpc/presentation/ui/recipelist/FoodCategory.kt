package com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist

import com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist.FoodCategory.*

enum class FoodCategory(val value: String, val numb : Int){
    CHICKEN("Chicken",0),
    BEEF("Beef",1),
    SOUP("Soup",2),
    DESSERT("Dessert",3),
    VEGETARIAN("Vegetarian",4),
    MILK("Milk",5),
    VEGAN("Vegan",6),
    PIZZA("Pizza",7),
    DONUT("Donut",8),
}

fun getAllFoodCategories(): List<FoodCategory>{
    return listOf(
        CHICKEN,BEEF, SOUP, DESSERT, VEGETARIAN, MILK, VEGAN, PIZZA, DONUT)
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = values().associateBy(FoodCategory::value)
    return map[value]
}

fun getSelectedFoodCategory(value: String): Int {
    val map = values().associateBy(FoodCategory::value)
    return map[value]?.numb ?: 0
}