package com.example.foodiemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.foodiemate.ui.navigation.NavigationBottomBar
import com.example.foodiemate.ui.navigation.NavigationGraph
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodieMateTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(), color = CustomTheme.colors.primaryBackground
                ) {
                    val navController = rememberNavController()
                    val scaffoldState = rememberBottomSheetScaffoldState()
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = {
                            NavigationBottomBar(navController)
                        },
                    ) { paddingValues ->
                        NavigationGraph(
                            navController = navController,
                            modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding())
                        )
                    }
                }
            }
        }
    }
}