package com.example.foodiemate.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foodiemate.R
import com.example.foodiemate.ui.theme.customTheme.CustomTheme

@Composable
fun AddFABMenu(modifier: Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(CustomTheme.colors.darkScreen)
        .clickable(
            indication = null, interactionSource = interactionSource, enabled = true
        ) {})
    ConstraintLayout(
        modifier = Modifier
            .size(CustomTheme.layoutSize.addFABBoxSize)
            .then(modifier)
            .background(
                CustomTheme.colors.FABBoxBackground, RoundedCornerShape(
                    topStartPercent = 100
                )
            )
    ) {
        val edgePadding = CustomTheme.layoutPadding.addFABEdgePadding
        val centerPadding = CustomTheme.layoutPadding.addFABCenterPadding
        val (mailFab, qrCodeFab, pencilFab) = createRefs()
        AddFABSmallIcon(Modifier.constrainAs(mailFab) {
            bottom.linkTo(parent.bottom, margin = edgePadding)
            start.linkTo(parent.start, margin = edgePadding)
        }, painterResource(R.drawable.mail), stringResource(R.string.add_by_mail))
        AddFABSmallIcon(Modifier.constrainAs(qrCodeFab) {
            top.linkTo(parent.top, margin = centerPadding)
            start.linkTo(parent.start, margin = centerPadding)
        }, painterResource(R.drawable.qr_code), stringResource(R.string.add_by_qr_code))
        AddFABSmallIcon(Modifier.constrainAs(pencilFab) {
            top.linkTo(parent.top, margin = edgePadding)
            end.linkTo(parent.end, margin = edgePadding)
        }, painterResource(R.drawable.pencil), stringResource(R.string.add_manually))
    }
}