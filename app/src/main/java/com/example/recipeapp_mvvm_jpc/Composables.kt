package com.example.recipeapp_mvvm_jpc

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Composables {

    @Composable
    fun ColumnExample(){
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
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
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
                Button(onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = "Yooo")
                }


            }
        }
    }

    @Composable
    fun RowExample(){
        Column {
            Row(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .border(border = BorderStroke(1.dp, Color.Black)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Item 1",
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
                Text(text = "Item 2",
//                modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(text = "Item 2",
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
            Column{
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

}