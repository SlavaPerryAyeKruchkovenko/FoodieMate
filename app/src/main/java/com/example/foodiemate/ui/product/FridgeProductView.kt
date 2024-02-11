package com.example.foodiemate.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.network.Mock
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeProductView(product: FridgeProduct) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        border = BorderStroke(1.dp, CustomTheme.colors.secondaryText),
        shape = RoundedCornerShape(CustomTheme.shapeRadius.card),
        colors = CardDefaults.cardColors(
            containerColor = CustomTheme.colors.secondaryBackground,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(CustomTheme.layoutPadding.cardTextPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(
                        CustomTheme.layoutSize.productImageSize,
                        CustomTheme.layoutSize.productImageSize
                    )
            ) {
                Image(
                    modifier = Modifier.size(CustomTheme.layoutSize.productImageSize),
                    painter = painterResource(id = R.drawable.cheese),
                    contentDescription = stringResource(R.string.product_image),
                    contentScale = ContentScale.Fit,
                )
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val (comp1, comp2, comp3) = createRefs()
                    Text(
                        modifier = Modifier
                            .constrainAs(comp1) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .fillMaxWidth()
                            .padding(CustomTheme.layoutPadding.cardTextPadding)
                            .heightIn(0.dp, CustomTheme.layoutSize.productImageSize),
                        style = TextStyle(
                            color = CustomTheme.colors.secondaryText,
                            fontSize = 18.sp,
                            fontFamily = FontFamily.SansSerif,
                            lineHeight = 20.sp,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        text = product.product.name,
                    )
                    Icon(
                        modifier = Modifier
                            .size(CustomTheme.layoutSize.smallIconSize)
                            .constrainAs(comp2) {
                                top.linkTo(parent.top)
                                end.linkTo(parent.end)
                            },
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.remove_product),
                        tint = CustomTheme.colors.removeProduct
                    )
                    Icon(
                        modifier = Modifier
                            .size(CustomTheme.layoutSize.smallIconSize)
                            .constrainAs(comp3) {
                                bottom.linkTo(parent.bottom)
                                end.linkTo(parent.end)
                            },
                        imageVector = Icons.Filled.Edit,
                        contentDescription = stringResource(id = R.string.edit_product),
                        tint = CustomTheme.colors.editProduct
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ProductUnit(product)
            }
        }
    }
}

@Preview
@Composable
private fun FridgeProductViewPreview() {
    val mockProducts = Mock.mockFridgeProduct()
    FridgeProductView(mockProducts.first())
}