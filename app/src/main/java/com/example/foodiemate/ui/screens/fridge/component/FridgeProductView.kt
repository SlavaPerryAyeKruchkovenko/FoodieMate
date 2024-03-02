package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val cardSize = CustomTheme.layoutSize.productImageSize
    val textSizeBox = CustomTheme.layoutSize.productTextSize
    val cardTextPadding = CustomTheme.layoutPadding.cardTextPadding
    var isEdit: Boolean by remember { mutableStateOf(false) }
    var productCount: Number by remember {
        mutableStateOf(product.count)
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, CustomTheme.colors.secondaryText),
        shape = RoundedCornerShape(CustomTheme.shapeRadius.card),
        colors = CardDefaults.cardColors(
            containerColor = CustomTheme.colors.secondaryBackground,
        )
    ) {
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
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(textSizeBox)
                ) {
                    val (comp1, comp2) = createRefs()
                    Text(
                        modifier = Modifier
                            .constrainAs(comp1) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .fillMaxWidth()
                            .padding(
                                top = cardTextPadding,
                                bottom = cardTextPadding,
                                start = cardTextPadding,
                                end = CustomTheme.layoutPadding.endCardTextPadding
                            )
                            .heightIn(0.dp, textSizeBox),
                        style = TextStyle(
                            color = CustomTheme.colors.secondaryText,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.SansSerif,
                            lineHeight = 16.sp,
                        ),
                        overflow = TextOverflow.Ellipsis,
                        text = product.product.name,
                    )
                    if (isEdit) {
                        ProductIcon(Icons.Rounded.Check,
                            R.string.accept,
                            CustomTheme.colors.acceptColor,
                            Modifier
                                .constrainAs(comp2) {
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end)
                                }
                                .clickable {
                                    isEdit = false
                                })
                    } else {
                        ProductIcon(Icons.Rounded.Edit,
                            R.string.edit_product,
                            CustomTheme.colors.editProduct,
                            Modifier
                                .constrainAs(comp2) {
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end)
                                }
                                .clickable {
                                    isEdit = true
                                })
                    }
                }
                if (isEdit) {
                    ProductUnitEditor(
                        value = productCount,
                        { v -> productCount = v },
                        modifier = Modifier.padding(top = CustomTheme.layoutPadding.productEditorPadding)
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
private fun FridgeProductViewPreview() {
    val mockProducts = Mock.mockFridgeProduct()
    FridgeProductView(mockProducts.first())
}