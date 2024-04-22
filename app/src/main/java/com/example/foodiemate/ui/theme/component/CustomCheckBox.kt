package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun CustomCheckBox(modifier: Modifier, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Icon(imageVector = Icons.Default.Check,
        contentDescription = "Custom Checkbox",
        tint = if (checked) CustomTheme.colors.primaryText else Color.Transparent,
        modifier = Modifier
            .then(modifier)
            .clickable { onCheckedChange(!checked) })
}

@Preview
@Composable
fun CustomCheckBoxPreview() {
    FoodieMateTheme {
        CustomCheckBox(modifier = Modifier.size(30.dp), checked = true) {}
    }
}
