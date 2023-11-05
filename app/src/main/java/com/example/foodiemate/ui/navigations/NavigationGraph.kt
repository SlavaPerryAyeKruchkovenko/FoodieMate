package com.example.foodiemate.ui.navigations

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodiemate.data.Screen
import com.example.foodiemate.ui.screens.FridgeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Fridge.screenName) {
        composable(Screen.Fridge.screenName) {
            FridgeScreen()
        }
        composable(Screen.Recipes.screenName) {
            Text(text = "recipes")
        }
        composable(Screen.None.screenName) {
            Text(text = "none")
        }
    }
}