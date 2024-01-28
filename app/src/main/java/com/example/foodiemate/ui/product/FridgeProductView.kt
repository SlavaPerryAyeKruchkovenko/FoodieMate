package com.example.foodiemate.ui.product

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct

@Composable
fun FridgeProductView(product: FridgeProduct) {
    Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(6.dp)) {

    }
}