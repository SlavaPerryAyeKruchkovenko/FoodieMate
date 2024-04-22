package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.foodiemate.datasource.presentationModels.models.CountedProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.customTheme.CustomTheme
import com.example.foodiemate.utils.NumberUtils
import com.example.foodiemate.utils.ProductUtils

@Composable
internal fun <T : CountedProduct> UnitProductView(
    product: T,
    modifier: Modifier = Modifier,
    content: @Composable (scope: ColumnScope, productCount: MutableState<Number>, unit: UnitOfMeasure) -> Unit
) {
    var unit by remember { mutableStateOf(product.product.unit) }
    val productCount = remember {
        mutableStateOf(product.count)
    }
    LaunchedEffect(product.product.unit) {
        if (unit != product.product.unit) {
            unit = product.product.unit
            val count =
                ProductUtils.convertCountByUnit(productCount.value.toDouble(), product.product.unit)
            productCount.value = NumberUtils.isInt<Number>(count, { count.toInt() }, { count })
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        shape = RoundedCornerShape(CustomTheme.shapeRadius.card),
        colors = CardDefaults.cardColors(
            containerColor = CustomTheme.colors.secondaryBackground,
        )
    ) {
        content(
            this,
            productCount,
            unit
        )
    }
}