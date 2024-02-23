package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun NavigationBottomBarItem(item: Screen, currentRoute: String?) {
    val selected by remember { mutableStateOf(item.screenName === currentRoute) }
    val color = if (selected)
        CustomTheme.colors.bottomNavigationTextSelected else
        CustomTheme.colors.bottomNavigationText
    Box(
        modifier = Modifier
            .height(CustomTheme.layoutSize.navigationBottomBarHeight)

    ) {
        Column() {
            HorizontalDivider(
                thickness = CustomTheme.layoutSize.bottomBarDivider,
                color = color
            )
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                modifier = Modifier.size(CustomTheme.layoutSize.mediumIconSize),
                tint = color
            )
            Text(
                stringResource(id = item.label),
                color = color,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}