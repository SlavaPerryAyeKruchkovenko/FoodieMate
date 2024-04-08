package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun ConfirmDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String?,
    icon: ImageVector,
    iconDescription: String?
) {
    val textSize = CustomTheme.fontSize.dialogTextFont
    AlertDialog(containerColor = CustomTheme.colors.dialogBackground, title = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .weight(0.1f)
                    .size(CustomTheme.layoutSize.dialogIcon),
                imageVector = icon,
                contentDescription = iconDescription,
                tint = CustomTheme.colors.primaryText
            )
            Text(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .weight(0.9f),
                fontSize = CustomTheme.fontSize.dialogTitleFont,
                fontWeight = FontWeight.Bold,
                text = dialogTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = CustomTheme.colors.primaryText
            )
        }
    }, text = {
        if (dialogText !== null) {
            Text(fontSize = textSize, text = dialogText, color = CustomTheme.colors.primaryText)
        }
    }, onDismissRequest = {
        onDismissRequest()
    }, confirmButton = {
        TextButton(onClick = {
            onConfirmation()
        }) {
            Text(
                fontSize = textSize,
                text = "Confirm",
                color = CustomTheme.colors.dialogButtonColor
            )
        }
    }, dismissButton = {
        TextButton(onClick = {
            onDismissRequest()
        }) {
            Text(
                fontSize = textSize,
                text = "Dismiss",
                color = CustomTheme.colors.dialogButtonColor
            )
        }
    })
}