package com.example.foodiemate.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.ui.navigations.NavigationBottomBar
import com.example.foodiemate.ui.navigations.NavigationGraph
import com.example.foodiemate.ui.theme.FoodieMateTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        bottomBar = {
            NavigationBottomBar(navController)
        }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    FoodieMateTheme {
        MainScreen()
    }
}