package com.example.foodiemate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.data.Screen
import com.example.foodiemate.ui.navigations.NavigationGraph

@Composable
fun MainScreen() {
    val navigationsBarItems = listOf(Screen.Fridge, Screen.Recipes, Screen.None, Screen.None)
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        bottomBar = {
            NavigationBar(modifier = Modifier.fillMaxWidth()) {
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
                                contentDescription = null
                            )
                        },
                    )
                }
            }
        }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}