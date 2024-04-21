package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.component.UnitProductView
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeProductView(
    product: FridgeProduct,
    isEdit: Boolean,
    onEnableEditProduct: () -> Unit,
    onEditProduct: (newValue: Number, newUnit: UnitOfMeasure) -> Unit,
    onDisableEditProduct: () -> Unit
) {
    val cardSize = CustomTheme.layoutSize.productImageSize
    val textSizeBox = CustomTheme.layoutSize.productTextSize
    val cardTextPadding = CustomTheme.layoutPadding.cardTextPadding
    UnitProductView(product) { scope, productCount, unit ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CustomTheme.layoutPadding.cardPadding)
                .heightIn(
                    cardSize, cardSize
                )
        ) {
            Image(
                modifier = Modifier.size(CustomTheme.layoutSize.productImageSize),
                painter = painterResource(id = R.drawable.cheese),
                contentDescription = stringResource(R.string.product_image),
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = CustomTheme.layoutPadding.cardTextBoxPadding)
            ) {
                FridgeProductCardView(
                    height = textSizeBox,
                    cardPadding = cardTextPadding,
                    isEdit = isEdit,
                    productName = product.product.name,
                    onEnableEditProduct = onEnableEditProduct,
                    onDisableEditProduct = onDisableEditProduct
                )

                if (isEdit) {
                    ProductUnitEditor(
                        value = productCount.value, {
                            onEditProduct(it, unit)
                            productCount.value = it
                        }, unit, modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(
                                CustomTheme.layoutSize.productEditorSize,
                                CustomTheme.layoutSize.productEditorSize
                            )
                    )
                } else {
                    ProductUnit(
                        product, modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(
                                CustomTheme.layoutSize.productEditorSize,
                                CustomTheme.layoutSize.productEditorSize
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FridgeProductViewPreview() {
    val mockProducts = Mock.mockFridgeProduct()
    var isEdit by remember {
        mutableStateOf(false)
    }
    FridgeProductView(mockProducts.first(), isEdit, {
        isEdit = true
    }, { _, _ -> }, {})
}