package com.example.recipeapp_mvvm_jpc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class RecipesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes,container,false)
        view.findViewById<ComposeView>(R.id.composeview).setContent {
            Column(
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, Color.Black)
                    )
                    .padding(16.dp)
            ) {
                Text(text = "New Fragment")
                CircularProgressIndicator()
                val customView = HorizontalDottedProgress(context)
                AndroidView(factory = {customView})
            }
        }

        return view

//        val v = ComposeView(requireContext()).apply{
//            setContent {
//                Text(text = "New Fragment")
//            }
//        }
    }
}