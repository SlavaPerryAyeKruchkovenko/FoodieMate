package com.example.foodiemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.ui.navigation.NavigationBottomBar
import com.example.foodiemate.ui.navigation.NavigationGraph
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieMateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CustomTheme.colors.primaryBackground
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = {
                            NavigationBottomBar(navController)
                        },
                    ) {
                        NavigationGraph(
                            navController = navController,
                            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
                        )
                    }
                }
            }
        }
    }
}