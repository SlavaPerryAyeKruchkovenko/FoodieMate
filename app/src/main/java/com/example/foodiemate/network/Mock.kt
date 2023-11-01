package com.example.foodiemate.network

import com.example.foodiemate.data.FridgeProduct
import com.example.foodiemate.data.Product
import java.util.*

object Mock {
    fun mockFridgeProduct(): List<FridgeProduct> {
        return listOf(
            FridgeProduct(
                "1",
                mockProducts().first { it.id === "1" },
                3,
                true,
                1,
                Date(),
                null
            ),
            FridgeProduct(
                "2",
                mockProducts().first { it.id === "2" },
                1,
                false,
                2,
                Date(),
                Date(12042002)
            ),
            FridgeProduct(
                "3",
                mockProducts().first { it.id === "3" },
                5,
                false,
                0,
                Date(),
                null
            ),
            FridgeProduct(
                "4",
                mockProducts().first { it.id === "4" },
                3,
                false,
                0,
                Date(),
                null
            ),
            FridgeProduct(
                "5",
                mockProducts().first { it.id === "5" },
                2,
                false,
                0,
                Date(),
                null
            ),
            FridgeProduct(
                "6",
                mockProducts().first { it.id === "6" },
                1,
                true,
                3,
                Date(),
                null
            )
        )
    }

    private fun mockProducts(): List<Product> {
        return listOf(
            Product("1", "Sausage", "Meat product", "Вязанка", "1"),
            Product("2", "Cheese", "Mozzarella", "Galbani", "2"),
            Product("3", "Cheese", "Feta", "Фетос", "3"),
            Product("4", "Sausage", "Smoked", "Московская", "4"),
            Product("5", "Milk", "Low- fat", "Простоквашено", "5"),
            Product("6", "Cucumber", "default", "Огурец", "6"),
            Product("7", "Tomato", "Barnaul", "Сто пудов", "6")
        )
    }
}