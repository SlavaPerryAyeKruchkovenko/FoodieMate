package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun NavigationBottomBarItem(
    screen: Screen, currentRoute: String?, navController: NavHostController
) {
    val selected by remember { mutableStateOf(screen.screenName === currentRoute) }
    val color =
        if (selected) CustomTheme.colors.bottomNavigationTextSelected else CustomTheme.colors.bottomNavigationText
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .clickable {
                navController.navigate(screen.screenName)
            },
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalDivider(
            modifier = Modifier.width(CustomTheme.layoutSize.bottomBarDividerWidth),
            thickness = CustomTheme.layoutSize.bottomBarDividerHeight,
            color = color
        )
        Icon(
            painter = painterResource(id = screen.icon),
            contentDescription = null,
            modifier = Modifier.size(CustomTheme.layoutSize.bottomBarIcon),
            tint = color
        )
        Text(
            stringResource(id = screen.label),
            color = color,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }

}