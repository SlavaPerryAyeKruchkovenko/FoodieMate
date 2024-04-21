package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.component.ProductIcon
import com.example.foodiemate.ui.theme.component.ProductUnit
import com.example.foodiemate.ui.theme.component.ProductUnitEditor
import com.example.foodiemate.ui.theme.component.UnitProductView
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketProductCard(
    product: BasketProduct,
    isEdit: Boolean,
    onEditProduct: (newValue: Number, newUnit: UnitOfMeasure) -> Unit,
    onEnableEditProduct: () -> Unit,
    onDisableEditProduct: () -> Unit,
    onSelect: (product: BasketProduct, isSelect: Boolean) -> Unit
) {
    UnitProductView(product) { scope, productCount, unit ->
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
            Column(
                modifier = Modifier
                    .fillMaxHeight().weight(2f)
            ) {
                Row(modifier = Modifier) {
                    Image(
                        modifier = Modifier.size(imageSize),
                        painter = painterResource(id = R.drawable.cheese),
                        contentDescription = stringResource(R.string.product_image),
                        contentScale = ContentScale.Fit,
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .height(imageSize)
                            .padding(start = dividerPadding),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = product.product.name,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 18.sp,
                            lineHeight = 20.sp
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = product.product.category.subCategory,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 18.sp,
                            lineHeight = 20.sp
                        )
                    }
                }
                if (isEdit) {
                    ProductUnitEditor(
                        value = productCount.value, {
                            onEditProduct(it, unit)
                            productCount.value = it
                        }, unit, modifier = Modifier.heightIn(
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
            Column(
                modifier = Modifier
                    .width(CustomTheme.layoutSize.basketCheckBoxSize)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                if (isEdit) {
                    ProductIcon(
                        Modifier.clickable {
                            onDisableEditProduct()
                        },
                        Icons.TwoTone.Check,
                        R.string.accept,
                        CustomTheme.colors.acceptColor,
                        CustomTheme.layoutSize.mediumIconSize
                    )
                } else {
                    ProductIcon(
                        Modifier.clickable {
                            onEnableEditProduct()
                        },
                        Icons.Rounded.Edit,
                        R.string.edit_product,
                        CustomTheme.colors.editProduct,
                        CustomTheme.layoutSize.mediumIconSize
                    )
                }
                Checkbox(modifier = Modifier.size(CustomTheme.layoutSize.basketCheckBoxSize),
                    checked = product.selected,
                    onCheckedChange = {
                        onSelect(product, it)
                    })
            }
        }
    }
}

@Preview
@Composable
fun BasketProductCardPreview() {
    FoodieMateTheme {
        val product = Mock.mockBasketProduct().first()
        BasketProductCard(product, false, { _, _ -> }, {}, {}, { _, _ -> })
    }
}