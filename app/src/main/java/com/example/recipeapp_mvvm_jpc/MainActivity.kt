package com.example.recipeapp_mvvm_jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipeapp_mvvm_jpc.ui.theme.RecipeApp_MVVM_JPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeApp_MVVM_JPCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
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
        Column{
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_background
                ),
                modifier = Modifier.height(300.dp),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeApp_MVVM_JPCTheme {
        Greeting("Android")
    }
}