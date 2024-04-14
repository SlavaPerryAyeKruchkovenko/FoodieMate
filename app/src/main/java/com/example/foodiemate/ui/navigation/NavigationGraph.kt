package com.example.foodiemate.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.screens.basket.BasketScreen
import com.example.foodiemate.ui.screens.basket.BasketViewModel
import com.example.foodiemate.ui.screens.fridge.FridgeScreen
import com.example.foodiemate.ui.screens.fridge.FridgeViewModel

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = Screen.Products.screenName, modifier = modifier) {
        composable(Screen.Products.screenName) {
            val fridgeViewModel = hiltViewModel<FridgeViewModel>()
            FridgeScreen(navController, fridgeViewModel)
        }
        composable(Screen.Basket.screenName) {
            val basketViewModel = hiltViewModel<BasketViewModel>()
            BasketScreen(navController = navController, viewModel = basketViewModel)
        }
        composable(Screen.Recipes.screenName) {
            val recipeViewModel = hiltViewModel<FridgeViewModel>()
            FridgeScreen(navController, recipeViewModel)
        }
        composable(Screen.None.screenName) {
            Text(text = "none")
        }
        composable(Screen.Tinder.screenName) {
            Text(text = "tinder")
        }
    }
}