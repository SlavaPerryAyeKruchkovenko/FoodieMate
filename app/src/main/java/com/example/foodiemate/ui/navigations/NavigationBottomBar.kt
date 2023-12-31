package com.example.foodiemate.ui.navigations

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.foodiemate.data.Screen
import com.example.foodiemate.ui.theme.Blue500
import com.example.foodiemate.ui.theme.Blue900
import com.example.foodiemate.ui.theme.White

@Composable
fun NavigationBottomBar(navController: NavHostController) {
    val navigationsBarItems = listOf(Screen.Fridge, Screen.Recipes, Screen.None, Screen.None)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = Blue500,
        contentColor = White,
    ) {
        navigationsBarItems.forEach { item ->
            NavigationBarItem(
                modifier = Modifier,
                selected = currentRoute == item.screenName,
                onClick = {
                    navController.navigate(item.screenName)
                },
                label = {
                    Text(
                        stringResource(id = item.label),
                        color = White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        tint = White
                    )
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(indicatorColor = Blue900)
            )
        }
    }
}