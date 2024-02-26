package com.example.foodiemate.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.screens.fridge.FridgeScreen
import com.example.foodiemate.ui.screens.fridge.FridgeViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Products.screenName) {
        composable(Screen.Products.screenName) {
            val fridgeViewModel = hiltViewModel<FridgeViewModel>()
            FridgeScreen(navController, fridgeViewModel)
        }
        composable(Screen.Recipes.screenName) {
            val fridgeViewModel = hiltViewModel<FridgeViewModel>()
            FridgeScreen(navController, fridgeViewModel)
        }
        composable(Screen.None.screenName) {
            Text(text = "none")
        }
        composable(Screen.Main.screenName) {
            Text(text = "main")
        }
        composable(Screen.Menu.screenName) {
            Text(text = "Menu")
        }
    }
}