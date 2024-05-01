package com.example.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Very basic Compose example showing some of the most basic features

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(
                    "Hello World",
                    fontSize = 24.sp,
                    color = Color.Red,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )

                Counter(
                    Modifier
                        .border(BorderStroke(2.dp, Color.Blue))
                        .padding(16.dp)
                )
                Spacer(Modifier.height(32.dp))
                Converter()
                Spacer(Modifier.height(32.dp))
                GreetingComponent()
            }
        }
    }

    @Composable
    fun Counter(mod: Modifier) {

        var state by remember { mutableStateOf(0) }
        Column(mod) {
            Button(onClick = { state = state + 1 }) {
                Text("Click!")
            }
            Text("You clicked $state times.")
        }
    }

    @Composable
    fun Converter() {
        var feetAsString by remember { mutableStateOf("") }
        Column {

            TextField(feetAsString, { feetAsString = it }, label = { Text("Enter feet") })

            Text("In metres that is: ${(feetAsString.toDoubleOrNull()?.times(0.305) ?: "")}")
        }
    }

    @Composable
    fun GreetingComponent() {
        var name by remember { mutableStateOf("") }
        Column {
            TextField(value = name, onValueChange = { name = it })
            Text("Hello $name!")
            Button(onClick = {
                name = ""
            }) {
                Text("Reset Name")
            }
        }
    }
}
