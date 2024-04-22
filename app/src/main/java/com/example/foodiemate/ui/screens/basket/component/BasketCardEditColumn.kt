package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.twotone.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.FoodieMateTheme
import com.example.foodiemate.ui.theme.component.CustomCheckBox
import com.example.foodiemate.ui.theme.component.ProductIcon
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketCardEditColumn(
    isEdit: Boolean,
    onEnableEditProduct: () -> Unit,
    onDisableEditProduct: () -> Unit,
    product: BasketProduct,
    onSelect: (product: BasketProduct, isSelect: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.then(modifier),
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
                CustomTheme.colors.primaryText,
                CustomTheme.layoutSize.mediumIconSize
            )
        }
        CustomCheckBox(modifier = Modifier
            .size(CustomTheme.layoutSize.basketCheckBoxSize)
            .background(CustomTheme.colors.editorBackground, RoundedCornerShape(10.dp))
            .padding(3.dp), checked = product.selected, onCheckedChange = {
            onSelect(product, it)
        })
    }
}

@Preview
@Composable
fun BasketCardEditColumnPreview() {
    FoodieMateTheme {
        val product = Mock.mockBasketProduct().first()
        BasketCardEditColumn(false, {}, {}, product, { _, _ -> })
    }
}