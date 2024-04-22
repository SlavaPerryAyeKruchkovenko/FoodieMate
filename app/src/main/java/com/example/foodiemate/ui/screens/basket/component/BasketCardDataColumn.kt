package com.example.foodiemate.ui.screens.basket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.BasketProduct
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure
import com.example.foodiemate.ui.theme.component.ProductUnit
import com.example.foodiemate.ui.theme.component.ProductUnitEditor
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun BasketCardDataColumn(
    modifier: Modifier = Modifier,
    imageSize: Dp,
    dividerPadding: Dp,
    product: BasketProduct,
    isEdit: Boolean,
    productCount: MutableState<Number>,
    onEditProduct: (newValue: Number, newUnit: UnitOfMeasure) -> Unit,
    unit: UnitOfMeasure
) {
    Column(
        modifier = Modifier.then(modifier)
    ) {
        Row(modifier = Modifier) {
            Image(
                modifier = androidx.compose.ui.Modifier.size(imageSize),
                painter = painterResource(id = R.drawable.cheese),
                contentDescription = stringResource(R.string.product_image),
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .padding(start = dividerPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = CustomTheme.colors.primaryText,
                    text = product.product.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    lineHeight = 20.sp
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    color = CustomTheme.colors.primaryText,
                    text = product.product.category.subCategory,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    lineHeight = 18.sp
                )
            }
        }
        val unitModifier = Modifier
            .fillMaxWidth()
            .heightIn(
                CustomTheme.layoutSize.productEditorSize,
                CustomTheme.layoutSize.productEditorSize
            )
            .padding(top = 6.dp)
        if (isEdit) {
            ProductUnitEditor(
                value = productCount.value, {
                    onEditProduct(it, unit)
                    productCount.value = it
                }, unit, modifier = unitModifier
            )
        } else {
            ProductUnit(
                product, modifier = unitModifier
            )
        }
    }
}