package com.example.foodiemate.ui.screens.fridge.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.component.ProductIcon
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun FridgeProductCardView(
    height: Dp,
    cardPadding: Dp,
    isEdit: Boolean,
    productName: String,
    onEnableEditProduct: () -> Unit,
    onDisableEditProduct: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
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
                    top = cardPadding,
                    bottom = cardPadding,
                    start = cardPadding,
                    end = CustomTheme.layoutPadding.endCardTextPadding
                )
                .heightIn(0.dp, height),
            style = TextStyle(
                color = CustomTheme.colors.primaryText,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 16.sp,
            ),
            overflow = TextOverflow.Ellipsis,
            text = productName,
        )
        if (isEdit) {
            ProductIcon(
                Modifier
                    .constrainAs(comp2) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .clickable {
                        onDisableEditProduct()
                    },
                Icons.TwoTone.Check,
                R.string.accept,
                CustomTheme.colors.acceptColor,
                CustomTheme.layoutSize.mediumIconSize
            )
        } else {
            ProductIcon(
                Modifier
                    .constrainAs(comp2) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .clickable {
                        onEnableEditProduct()
                    },
                Icons.Rounded.Edit,
                R.string.edit_product,
                CustomTheme.colors.primaryText,
                CustomTheme.layoutSize.mediumIconSize
            )
        }
    }
}

@Preview
@Composable
fun FridgeProductTitleCardPreview() {
    FridgeProductCardView(80.dp, 6.dp, false, "example", {}, {})
}