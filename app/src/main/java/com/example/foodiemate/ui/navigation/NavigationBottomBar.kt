package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun NavigationBottomBar(navController: NavHostController) {
    val navigationBarItems = listOf(Screen.Main, Screen.Recipes, Screen.Products, Screen.Menu)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = CustomTheme.colors.bottomNavigationBackground,
        contentColor = CustomTheme.colors.bottomNavigationText,
    ) {
        navigationBarItems.forEach { item ->
            NavigationBottomBarItem(item, currentRoute)
        }
    }
}