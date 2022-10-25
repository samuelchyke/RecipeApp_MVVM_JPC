package com.example.recipeapp_mvvm_jpc.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.recipeapp_mvvm_jpc.R
import com.example.recipeapp_mvvm_jpc.model.Recipe
import com.example.recipeapp_mvvm_jpc.presentation.ui.recipelist.RecipeListFragmentDirections
import com.example.recipeapp_mvvm_jpc.ui.theme.RecipeApp_MVVM_JPCTheme
import com.example.recipeapp_mvvm_jpc.util.DEFAULT_RECIPE_IMAGE
import com.example.recipeapp_mvvm_jpc.util.FoodCategory
import com.example.recipeapp_mvvm_jpc.util.getAllFoodCategories
import com.example.recipeapp_mvvm_jpc.util.loadPicture
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

object Composables {

    @Composable
    fun ColumnExample() {
        Surface(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF2F2F2))
        ) {
            Column {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_launcher_background
                    ),
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Hello",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Green
                        )
                    )
                    Text(
                        text = "Ohayo",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "Ohayo")
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Yooo")
                }


            }
        }
    }

    @Composable
    fun RowExample() {
        Column {
            Row(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .border(border = BorderStroke(1.dp, Color.Black)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Item 1",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(border = BorderStroke(1.dp, Color.Black)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Item 2",
//                modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "Item 2",
//                modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Color(0xFFF2F2F2))
        ) {
            Column {
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_launcher_background
                    ),
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Hello $name!",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Green
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = "Hello $name!")
                }
            }
        }

    }

    @Composable
    fun RecipeCard(
        recipe: Recipe,
        onClick: () -> Unit
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(
                    bottom = 6.dp,
                    top = 6.dp
                )
                .fillMaxWidth()
                .clickable(onClick = onClick),
            elevation = 8.dp
        ) {
            Column {
                recipe.featured_image?.let { url ->
                    GlideImage(
                        imageModel = url,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        imageOptions = ImageOptions(
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        ),
                        //Loading Image with shimmer
                        component = rememberImageComponent {
                            // shows a shimmering effect when loading an image.
                            +ShimmerPlugin(
                                baseColor = Color.Gray,
                                highlightColor = Color.White
                            )
                        }
                        //Loading Image with placeholder
//                        component = imageComponent {
//                            +PlaceholderPlugin.Loading(painterResource(id = R.drawable.empty_plate))
//                            +PlaceholderPlugin.Failure(painterResource(id = R.drawable.empty_plate))
//                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            bottom = 10.dp,
                            start = 8.dp,
                            end = 8.dp
                        )
                        .fillMaxWidth()
                ) {
                    Text(
                        text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(0.50f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = "Rating: ${recipe.rating}/100",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }

    @Composable
    fun FoodCategoryChip(
        category: String,
        isSelected : Boolean,
        onExecuteSearch: () -> Unit,
        onSearchCategoryChanged: (String) -> Unit,
    ){
        Surface(
            modifier = Modifier.padding(end = 8.dp),
            elevation = 8.dp,
            shape = MaterialTheme.shapes.medium,
            color = if (isSelected) Color.White else MaterialTheme.colors.primary
        ) {
            Row(
                modifier = Modifier.toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSearchCategoryChanged(category)
                        onExecuteSearch()
                    }
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = category,
                    style = MaterialTheme.typography.body2,
                    color = if (isSelected) Color.Black else Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }

    @Composable
    fun SearchAppBar(
        query : String,
        selectedCategory : FoodCategory?,
        selectedChip : Int,
        onQueryChanged : (String) -> Unit,
        onExecuteSearch : () -> Unit,
        clearFocus : () -> Unit,
        onClearSelectedCategory: () -> Unit,
        onSelectedCategoryChanged: (String) -> Unit
    ){
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colors.primary,
            elevation = 8.dp,
        ){
            Column {
                Row(modifier = Modifier.fillMaxWidth()){
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = query,
                        onValueChange = {
                            onQueryChanged(it)
                        },
                        label = {
                            Text(text = "Search")
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search Image"
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                onExecuteSearch()
                                clearFocus()
                                onClearSelectedCategory()
                            }
                        ),
                    )
                }

                ScrollableTabRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp, bottom = 2.dp),
                    selectedTabIndex = selectedChip,
                    edgePadding = 2.dp,
                    indicator = {
                        TabRowDefaults.Indicator(
                            color = Color.White,
                            height = 0.dp,
                            modifier = Modifier.tabIndicatorOffset(it[0])
                        )
                    }
                ) {
                    for (category in getAllFoodCategories()){
                        FoodCategoryChip(
                            category = category.value,
                            isSelected = selectedCategory == category,
                            onExecuteSearch = {onExecuteSearch()},
                            onSearchCategoryChanged = {
                                onSelectedCategoryChanged(it)
                            }

                        )
                    }
                }
            }
        }
    }

    @Composable
    fun RecipeCard2(
        recipe: Recipe,
        onClick: () -> Unit
    ) {
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(
                    bottom = 6.dp,
                    top = 6.dp
                )
                .fillMaxWidth()
                .clickable(onClick = onClick),
            elevation = 8.dp
        ) {
            Column {
                recipe.featured_image?.let { url ->
                    val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE)
                        .value
                    image?.let { img ->
                        Image(
                            bitmap = img.asImageBitmap(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(225.dp),
                            contentScale = ContentScale.Crop,
                            contentDescription = "emptyPlate"
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(
                            top = 10.dp,
                            bottom = 10.dp,
                            start = 8.dp,
                            end = 8.dp
                        )
                        .fillMaxWidth()
                ) {
                    Text(
                        text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(0.50f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = "Rating: ${recipe.rating}/100",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.h5
                    )
                }

            }

        }
    }

    @Composable
    fun RecipeList(
        loading: Boolean,
        recipes: List<Recipe>,
        onChangeScrollPosition: (Int) -> Unit,
        page: Int,
        onTriggerNextPage: () -> Unit,
        navController: NavController,
    ){
        Box(
            modifier = Modifier.background(color = MaterialTheme.colors.surface)
        ) {
                LazyColumn {
                    itemsIndexed(
                        items = recipes
                    ) { index, recipe ->
                        onChangeScrollPosition(index)
                        if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                            onTriggerNextPage()
                        }
                        RecipeCard(
                            recipe = recipe,
                            onClick = {
                                val nav = RecipeListFragmentDirections.navToRecipeFragment(recipe)
                                navController.navigate(nav)
                            }
                        )
                    }
                    }
                }
                CircularIndeterminateProgressBar(isDisplayed = loading)
    }

    @Composable
    fun CircularIndeterminateProgressBar(isDisplayed: Boolean) {
        if (isDisplayed) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary
                )
            }
        }
    }

}








@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeApp_MVVM_JPCTheme {
//        Greeting("Android")
//        Composables.ColumnExample()
//        RowExample()

    }
}