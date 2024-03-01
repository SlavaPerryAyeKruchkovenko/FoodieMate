package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun AddFABSmallIcon(modifier: Modifier, painter: Painter, contentDescription: String) {
    FloatingActionButton(modifier = Modifier
        .size(CustomTheme.layoutSize.addFABSmallSize)
        .border(1.dp, CustomTheme.colors.addFABIconTint, CircleShape)
        .then(modifier),
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        containerColor = CustomTheme.colors.addFABBackground,
        onClick = {}) {
        Icon(
            painter,
            contentDescription,
            modifier = Modifier.size(CustomTheme.layoutSize.addSmallFABIconSize),
            tint = CustomTheme.colors.addFABIconTint,
        )
    }
}