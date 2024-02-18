package com.example.foodiemate.ui.navigations

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.screens.fridge.FridgeScreen
import com.example.foodiemate.ui.screens.fridge.FridgeViewModel
import com.example.foodiemate.ui.screens.recipe.RecipeScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Fridge.screenName) {
        composable(Screen.Fridge.screenName) {
            val fridgeViewModel = hiltViewModel<FridgeViewModel>()
            FridgeScreen(navController, fridgeViewModel)
        }
        composable(Screen.Recipes.screenName) {
            RecipeScreen()
        }
        composable(Screen.None.screenName) {
            Text(text = "none")
        }
    }
}