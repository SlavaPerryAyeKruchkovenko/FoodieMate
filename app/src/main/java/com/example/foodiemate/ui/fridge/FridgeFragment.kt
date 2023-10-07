package com.example.foodiemate.ui.fridge

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun FridgeFragment(navController: NavHostController) {
    Column {
        Text(text = "Screen 1")
        Button(onClick = { navController.navigate("screen2") }) {
            Text(text = "Go to Screen 2")
        }
    }
}

@Preview()
@Composable
fun FridgeFragmentPreview() {
    val navController: NavHostController = rememberNavController()
    FridgeFragment(navController = navController)
}