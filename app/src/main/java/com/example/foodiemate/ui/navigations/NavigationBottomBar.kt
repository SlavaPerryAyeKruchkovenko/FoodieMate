package com.example.foodiemate.ui.navigations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodiemate.data.Screen
import com.example.foodiemate.ui.theme.Blue500

@Composable
fun NavigationBottomBar(navController: NavHostController) {
    val navigationsBarItems = listOf(Screen.Fridge, Screen.Recipes, Screen.None, Screen.None)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(modifier = Modifier.fillMaxWidth(), containerColor = Blue500) {
        navigationsBarItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screenName,
                onClick = {
                    navController.navigate(item.screenName)
                },
                label = { Text(stringResource(id = item.label)) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                },
            )
        }
    }
}