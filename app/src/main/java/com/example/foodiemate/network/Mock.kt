package com.example.foodiemate.network

import com.example.foodiemate.datasource.presentationModels.models.Family
import com.example.foodiemate.datasource.presentationModels.models.FridgeProduct
import com.example.foodiemate.datasource.presentationModels.models.Product
import com.example.foodiemate.datasource.presentationModels.models.ProductCategory
import com.example.foodiemate.datasource.presentationModels.models.UnitOfMeasure

object Mock {
    fun mockFridgeProduct(): List<FridgeProduct> {
        return listOf(
            FridgeProduct(
                "1",
                mockProducts().first { it.id === "1" },
                124,
                mockFamily,
            ),
            FridgeProduct(
                "2",
                mockProducts().first { it.id === "2" },
                500,
                mockFamily,
            ),
            FridgeProduct(
                "3",
                mockProducts().first { it.id === "3" },
                100,
                mockFamily,
            ),
            FridgeProduct(
                "4",
                mockProducts().first { it.id === "4" },
                13,
                mockFamily,
            ),
            FridgeProduct(
                "5",
                mockProducts().first { it.id === "5" },
                800,
                mockFamily,
            ),
            FridgeProduct(
                "6",
                mockProducts().first { it.id === "6" },
                3,
                mockFamily,
            ),
            FridgeProduct(
                "7",
                mockProducts().first { it.id === "7" },
                1.4,
                mockFamily,
            ),
            FridgeProduct(
                "8",
                mockProducts().first { it.id === "8" },
                230,
                mockFamily,
            )
        )
    }

    private fun mockProducts(): List<Product> {
        return listOf(
            Product(
                "1",
                mockProductCategory().first { it.id === "2" },
                "Сосиски Моя цена деревенские",
                UnitOfMeasure.Gram,
            ),
            Product(
                "2",
                mockProductCategory().first { it.id === "1" },
                "Хлебцы Бородинские Щедрые",
                UnitOfMeasure.Gram
            ),
            Product(
                "3",
                mockProductCategory().first { it.id === "6" },
                "Сыр рассольный Первый вкус Mozzarella Ciliegine 45 % Сыр рассольный Первый вкус Mozzarella Ciliegine 45 %",
                UnitOfMeasure.Gram
            ),
            Product(
                "4",
                mockProductCategory().first { it.id === "3" },
                "Премиум бананы мама негра",
                UnitOfMeasure.Piece
            ),
            Product(
                "5",
                mockProductCategory().first { it.id === "4" },
                "Томаты Помидорка неочищенные в собственном соку",
                UnitOfMeasure.Liter
            ),
            Product(
                "6",
                mockProductCategory().first { it.id === "5" },
                "Напиток Добрый Кола без сахара",
                UnitOfMeasure.Liter
            ),
            Product(
                "7",
                mockProductCategory().first { it.id === "5" },
                "Напиток Черноголовка Мандарин газированный",
                UnitOfMeasure.Liter
            ),
            Product(
                "8",
                mockProductCategory().first { it.id === "2" },
                "Ветчина Вязанка Филейская Столичная",
                UnitOfMeasure.Gram
            ),
        )
    }

    private fun mockProductCategory(): List<ProductCategory> {
        return listOf(
            ProductCategory("1", "мучное и булочное", "Хлебцы"),
            ProductCategory("2", "мясная продукция", "Сосиски"),
            ProductCategory("3", "фрукты", "Бананы"),
            ProductCategory("4", "овощи", "Помидоры"),
            ProductCategory("5", "напитки", "газировка"),
            ProductCategory("6", "молочные продукты", "сыры"),
        )
    }

    private val mockFamily: Family = Family("1", "Gay party")
}