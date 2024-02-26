package com.example.foodiemate.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.foodiemate.datasource.presentationModels.Screen
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun NavigationBottomBarItem(
    screen: Screen, contentColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalDivider(
            modifier = Modifier.width(CustomTheme.layoutSize.bottomBarDividerWidth),
            thickness = CustomTheme.layoutSize.bottomBarDividerHeight,
            color = contentColor
        )
        Icon(
            painter = painterResource(id = screen.icon),
            contentDescription = null,
            modifier = Modifier.size(CustomTheme.layoutSize.bottomBarIcon),
            tint = contentColor
        )
        Text(
            stringResource(id = screen.label),
            color = contentColor,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }

}