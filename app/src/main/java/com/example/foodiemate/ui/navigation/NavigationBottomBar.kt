package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
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
    Row(
        modifier = Modifier
            .background(CustomTheme.colors.bottomNavigationBackground)
            .fillMaxWidth()
            .height(CustomTheme.layoutSize.navigationBottomBarHeight)
            .padding(
                CustomTheme.layoutPadding.horizontalNavigationBarPadding,
                CustomTheme.layoutPadding.verticalNavigationBarPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        navigationBarItems.forEach { item ->
            NavigationBottomBarItem(item, currentRoute, navController)
        }
    }
}