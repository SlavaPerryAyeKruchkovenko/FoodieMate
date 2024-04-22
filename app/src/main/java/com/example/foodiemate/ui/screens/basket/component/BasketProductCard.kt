package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.component.UnitProductView
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketProductCard(
    product: BasketProduct,
    isEdit: Boolean,
    onEditProduct: (newValue: Number, newUnit: UnitOfMeasure) -> Unit,
    onEnableEditProduct: () -> Unit,
    onDisableEditProduct: () -> Unit,
    onSelect: (product: BasketProduct, isSelect: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    UnitProductView(product = product, modifier = modifier) { _, productCount, unit ->
        val cardSize = CustomTheme.layoutSize.productCardSize
        val imageSize = CustomTheme.layoutSize.basketProductImageSize
        val dividerPadding = CustomTheme.layoutPadding.productCardDividerPadding
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CustomTheme.layoutPadding.cardPadding)
                .heightIn(
                    cardSize, cardSize
                )
        ) {
            BasketCardDataColumn(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                imageSize = imageSize,
                dividerPadding = dividerPadding,
                product = product,
                isEdit = isEdit,
                productCount = productCount,
                onEditProduct = onEditProduct,
                unit = unit
            )
            BasketCardEditColumn(
                isEdit = isEdit,
                onEnableEditProduct = onEnableEditProduct,
                onDisableEditProduct = onDisableEditProduct,
                product = product,
                onSelect = onSelect,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(CustomTheme.layoutSize.basketCheckBoxSize)
                    .fillMaxHeight()
            )
        }
    }
}

@Preview
@Composable
fun BasketProductCardPreview() {
    FoodieMateTheme {
        val product = Mock.mockBasketProduct()[2]
        BasketProductCard(product, false, { _, _ -> }, {}, {}, { _, _ -> })
    }
}