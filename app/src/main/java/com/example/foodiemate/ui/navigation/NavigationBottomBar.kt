package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
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
    val backgroundColor = CustomTheme.colors.bottomNavigationBackground
    BottomAppBar(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .height(CustomTheme.layoutSize.navigationBottomBarHeight),
        containerColor = backgroundColor,
    ) {
        navigationBarItems.forEach { item ->
            val selected = currentRoute == item.screenName
            val color =
                if (selected) CustomTheme.colors.bottomNavigationTextSelected else CustomTheme.colors.bottomNavigationText/*val animatedColor by animateColorAsState(
                targetValue = color,
                animationSpec = TweenSpec(
                    durationMillis = 200,
                    easing = FastOutSlowInEasing
                ), label = ""
            )*/
            NavigationBarItem(modifier = Modifier, selected = selected, onClick = {
                navController.navigate(item.screenName)
            }, icon = {
                NavigationBottomBarItem(item, color)
            }, colors = NavigationBarItemDefaults.colors(indicatorColor = backgroundColor)
            )
        }
    }
}