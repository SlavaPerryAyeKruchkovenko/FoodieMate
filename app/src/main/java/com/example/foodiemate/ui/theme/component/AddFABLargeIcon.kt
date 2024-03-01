package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun AddFABLargeIcon(
    modifier: Modifier,
    onClick: () -> Unit,
    painter: ImageVector,
    contentDescription: String
) {
    FloatingActionButton(
        modifier = Modifier
            .size(CustomTheme.layoutSize.addFABSize)
            .border(1.dp, CustomTheme.colors.addFABIconTint, CircleShape)
            .then(modifier),
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(0.dp),
        containerColor = CustomTheme.colors.addFABBackground,
        onClick = onClick
    ) {
        Icon(
            painter,
            contentDescription,
            tint = CustomTheme.colors.addFABIconTint,
            modifier = Modifier.size(CustomTheme.layoutSize.addFABIconSize)
        )
    }
}