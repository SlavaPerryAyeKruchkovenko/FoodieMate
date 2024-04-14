package com.example.foodiemate.ui.theme.customTheme

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp

object CustomModifier {
    fun Modifier.tabIndicatorOffset(
        start: Dp, width: Dp
    ): Modifier = composed {
        val currentTabWidth by animateDpAsState(
            targetValue = width,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            label = "tab width"
        )
        val indicatorOffset by animateDpAsState(
            targetValue = start,
            animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
            label = "tab offset"
        )
        fillMaxWidth()
            .wrapContentSize(Alignment.BottomStart)
            .offset(x = indicatorOffset)
            .width(currentTabWidth)
    }

    @SuppressLint("ModifierFactoryUnreferencedReceiver", "UnnecessaryComposedModifier")
    fun Modifier.paddingForCard(
        index: Int,
        itemsSize: Int,
        firstItemMargin: Dp,
        lastItemMargin: Dp,
        itemCardMargin: Dp
    ): Modifier = composed {
        when (index) {
            0 -> {
                padding(top = firstItemMargin)
            }

            itemsSize - 1 -> {
                padding(
                    top = itemCardMargin,
                    bottom = lastItemMargin,
                )
            }

            else -> {
                padding(top = itemCardMargin)
            }
        }
    }
}