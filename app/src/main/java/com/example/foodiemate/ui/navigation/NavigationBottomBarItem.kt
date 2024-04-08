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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
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
            imageVector = ImageVector.vectorResource(id = screen.icon),
            contentDescription = stringResource(id = screen.label),
            modifier = Modifier.size(CustomTheme.layoutSize.bottomBarIcon),
            tint = contentColor
        )
        Text(
            stringResource(id = screen.label),
            color = contentColor,
            fontSize = CustomTheme.fontSize.bottomBarItemFont,
            fontWeight = FontWeight.Bold
        )
    }

}