package com.example.foodiemate.network

import com.example.foodiemate.R
import com.example.foodiemate.data.models.Family
import com.example.foodiemate.data.models.FridgeProduct
import com.example.foodiemate.data.models.KBZhURecipe
import com.example.foodiemate.data.models.Product
import com.example.foodiemate.data.models.Recipe
import com.example.foodiemate.data.models.RecipeCategory
import com.example.foodiemate.data.models.RecipeProduct
import com.example.foodiemate.data.models.RecipeProductCountType
import com.example.foodiemate.data.models.RecipeStep
import com.example.foodiemate.data.models.User
import com.example.foodiemate.data.models.VisibleStatus
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
            ),
            FridgeProduct(
                "7",
                mockProducts().first { it.id === "7" },
                3,
                false,
                3,
                Date(),
                null
            ),
            FridgeProduct(
                "8",
                mockProducts().first { it.id === "8" },
                23,
                true,
                3,
                Date(),
                null
            )
        )
    }

    fun mockRecipes(): List<Recipe> {
        val date = GregorianCalendar(2023, 11, 18, 10, 10).time
        return listOf(
            Recipe(
                "0",
                mockUser(),
                mockKBZhU()[0],
                mockCategory()[0],
                "Яищница",
                4.2,
                VisibleStatus.PUBLIC,
                "Глазунья сделанная с душей",
                "",
                mockRecipeSteps(),
                mockRecipeProduct(),
                Date(),
                true,
            ),
            Recipe(
                "1",
                mockUser(),
                mockKBZhU()[1],
                mockCategory()[0],
                "Омлет",
                4.82,
                VisibleStatus.PUBLIC,
                "Омлет из белков",
                "",
                listOf(),
                listOf(),
                date,
                false,
            ),
            Recipe(
                "2",
                mockUser(),
                mockKBZhU()[2],
                mockCategory()[1],
                "Торт Пашка",
                3.43,
                VisibleStatus.PUBLIC,
                "Торт любимчик пашка приготовленный в домашних условиях",
                "",
                listOf(),
                listOf(),
                date,
                false,
            ),
            Recipe(
                "3",
                mockUser(),
                mockKBZhU()[3],
                mockCategory()[1],
                "Торт Прага",
                2.21,
                VisibleStatus.PUBLIC,
                "Классический по ГОСТу",
                "",
                listOf(),
                listOf(),
                Date(),
                true,
            ),
            Recipe(
                "4",
                mockUser(),
                mockKBZhU()[4],
                mockCategory()[2],
                "Цезарь",
                4.09,
                VisibleStatus.PUBLIC,
                "Простой цезарь",
                "",
                listOf(),
                listOf(),
                date,
                true,
            ),
            Recipe(
                "5",
                mockUser(),
                mockKBZhU()[5],
                mockCategory()[2],
                "Салат оливье",
                4.762,
                VisibleStatus.PUBLIC,
                "Советский салат оливье",
                "",
                listOf(),
                listOf(),
                date,
                false,
            ),
            Recipe(
                "6",
                mockUser(),
                mockKBZhU()[6],
                mockCategory()[3],
                "Лимонад",
                3.82,
                VisibleStatus.PUBLIC,
                "Домашний лимонад из апельсина и лимона",
                "",
                listOf(),
                listOf(),
                date,
                false,
            ),
            Recipe(
                "7",
                mockUser(),
                mockKBZhU()[7],
                mockCategory()[3],
                "Малиновый сбитень",
                1.73,
                VisibleStatus.PUBLIC,
                "Малиновый коктель",
                "",
                listOf(),
                listOf(),
                Date(),
                true,
            ),
            Recipe(
                "8",
                mockUser(),
                mockKBZhU()[8],
                mockCategory()[4],
                "Зеленный борщ",
                4.73,
                VisibleStatus.PUBLIC,
                "Зелёный борщ со щавелем и яйцами",
                "",
                listOf(),
                listOf(),
                date,
                true,
            ),
            Recipe(
                "9",
                mockUser(),
                mockKBZhU()[9],
                mockCategory()[4],
                "Харчо",
                0.42,
                VisibleStatus.PUBLIC,
                "Суп харчо — одно из наиболее известных блюд кавказской кухни",
                "",
                listOf(),
                listOf(),
                date,
                true,
            )
        )
    }

    private fun mockRecipeSteps(): List<RecipeStep> {
        return listOf(
            RecipeStep("0", 1, null, "Разбейте 2 яйца"),
            RecipeStep("1", 2, null, "Слегка прогрейте сковородку"),
            RecipeStep("2", 3, null, "Влейте растительное масло"),
            RecipeStep(
                "3",
                4,
                null,
                "Выльейте яйца на сковородку и жарьте их на медленном огне 4-5 минуты"
            ),
            RecipeStep("4", 5, null, "Натрите 100 грамм сыра на терке"),
            RecipeStep(
                "5",
                6,
                null,
                "Выложите сыр и сосиски на сковородку и жарьте еще 2 минуты, поворачивая сосиски"
            ),
            RecipeStep(
                "6",
                7,
                "https://podacha-blud.com/uploads/posts/2022-10/1665577750_8-podacha-blud-com-p-fud-foto-sosiski-yaitsa-zavtrak-11.jpg",
                "Яичница готова"
            ),
        )
    }

    private fun mockRecipeProduct(): List<RecipeProduct> {
        val products = mockProducts()
        return listOf(
            RecipeProduct("0", products[0], 2.0, RecipeProductCountType.COUNT),
            RecipeProduct("1", products[1], 100.0, RecipeProductCountType.GRAM),
            RecipeProduct("2", products[8], 2.0, RecipeProductCountType.COUNT),
            RecipeProduct("3", products[9], 2.0, RecipeProductCountType.COUNT)
        )
    }

    private fun mockKBZhU(): List<KBZhURecipe> {
        return listOf(
            KBZhURecipe("0", 120.1, 12.05, 20.0, 88.5),
            KBZhURecipe("1", 232.4, 32.82, 50.18, 150.4),
            KBZhURecipe("2", 388.9, 12.4, 76.4, 300.1),
            KBZhURecipe("3", 412.0, 22.0, 70.0, 320.0),
            KBZhURecipe("4", 160.45, 58.12, 6.24, 96.09),
            KBZhURecipe("5", 210.1, 72.08, 12.01, 126.01),
            KBZhURecipe("6", 288.35, 38.12, 32.22, 218.01),
            KBZhURecipe("7", 477.14, 47.04, 100.01, 300.09),
            KBZhURecipe("8", 182.1, 42.01, 40.07, 100.02),
            KBZhURecipe("9", 220.6, 42.13, 68.47, 110.0)
        )
    }

    fun mockCategory(): List<RecipeCategory> {
        return listOf(
            RecipeCategory(
                "0", "Завтрак", R.drawable.breakfast
            ),
            RecipeCategory(
                "1", "Дисерт", R.drawable.cake
            ),
            RecipeCategory(
                "2", "Салат", R.drawable.salad
            ),
            RecipeCategory(
                "3", "Напитки", R.drawable.soda
            ),
            RecipeCategory(
                "4", "Супы", R.drawable.soup
            )
        )
    }

    private fun mockUser(): User {
        val date = GregorianCalendar(2002, 4, 12, 12, 12).time
        return User("1", "User@Example", "user@example.com", date, mockFamily())
    }

    private fun mockFamily(): Family {
        return Family("1", "Best Family")
    }

    private fun mockProducts(): List<Product> {
        return listOf(
            Product("1", "Sausage", "Meat product", "Вязанка", "Колбаса Варенная", "1"),
            Product("2", "Cheese", "Mozzarella", "Galbani", "Сыр Моцарелла", "2"),
            Product("3", "Cheese", "Feta", "Фетос", "Сыр кубиком", "3"),
            Product("4", "Sausage", "Smoked", "Московская", "Колбаса", "4"),
            Product("5", "Milk", "Low- fat", "Простоквашено", "Молоко", "5"),
            Product("6", "Vegetables", "Cucumber", null, "Огурец", "6"),
            Product("7", "Vegetables", "Tomato", "Сто пудов", "Помидор", "7"),
            Product("8", "Fruits", "Banana", "Мама негра", "Бананы", "8"),
            Product("9", "Egg", "Egg", "Ариант", "Яйца домашние", "9"),
            Product("10", "Oil", "olive", "Filippo Berio", "Оливковое масло", "10"),
        )
    }
}