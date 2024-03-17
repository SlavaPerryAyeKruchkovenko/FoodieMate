package com.example.foodiemate.utils

object NumberUtils {
    inline fun <T> isInt(number: Double, onInt: () -> T, onDouble: () -> T): T {
        return if (number - number.toInt() == 0.0) onInt() else onDouble()
    }
}