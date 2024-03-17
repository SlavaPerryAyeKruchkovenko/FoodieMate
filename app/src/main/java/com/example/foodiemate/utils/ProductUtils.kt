package com.example.foodiemate.utils

import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure

object ProductUtils {
    fun convertCountByUnit(count: Double, unit: UnitOfMeasure): Double {
        return when (unit) {
            UnitOfMeasure.Kilogram -> count / 1000
            UnitOfMeasure.Liter -> count / 1000
            UnitOfMeasure.Gram -> count * 1000
            UnitOfMeasure.Milliliter -> count * 1000
            else -> count
        }
    }

    fun getProductCountTitle(count: Number, unit: UnitOfMeasure): String {
        val allowedUnits = listOf(UnitOfMeasure.Kilogram, UnitOfMeasure.Liter, UnitOfMeasure.Piece)
        return if (count.toDouble() >= 100 && unit in allowedUnits) {
            "+99"
        } else {
            count.toString()
        }
    }
}