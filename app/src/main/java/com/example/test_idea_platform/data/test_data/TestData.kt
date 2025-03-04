package com.example.test_idea_platform.data.test_data

import com.example.test_idea_platform.domain.DeviceModel
class TestData {

    companion object {
        fun getTestData(): List<DeviceModel> {
            return listOf(
                DeviceModel(
                    id = 1,
                    name = "iPhone 13",
                    time = 1633046400000,
                    tags = arrayListOf("Телефон", "Новый", "Распродажа"),
                    amount = 15
                ),
                DeviceModel(
                    id = 2,
                    name = "Samsung Galaxy S21",
                    time = 1633132800000,
                    tags = arrayListOf("Телефон", "Хит"),
                    amount = 30
                ),
                DeviceModel(
                    id = 3,
                    name = "PlayStation 5",
                    time = 1633219200000,
                    tags = arrayListOf("Игровая приставка", "Акция", "Распродажа"),
                    amount = 7
                ),
                DeviceModel(
                    id = 4,
                    name = "LG OLED TV",
                    time = 1633305600000,
                    tags = arrayListOf("Телевизор", "Эксклюзив", "Ограниченный"),
                    amount = 22
                ),
                DeviceModel(
                    id = 5,
                    name = "Apple Watch Series 7",
                    time = 1633392000000,
                    tags = arrayListOf("Часы", "Новый", "Рекомендуем"),
                    amount = 0
                ),
                DeviceModel(
                    id = 6,
                    name = "Xiaomi Mi 11",
                    time = 1633478400000,
                    tags = arrayListOf("Телефон", "Скидка", "Распродажа"),
                    amount = 5
                ),
                DeviceModel(
                    id = 7,
                    name = "MacBook Air M1",
                    time = 1633564800000,
                    tags = arrayListOf("Ноутбук", "Тренд"),
                    amount = 12
                ),
                DeviceModel(
                    id = 8,
                    name = "Amazon Kindle Paperwhite",
                    time = 1633651200000,
                    tags = arrayListOf("Электронная книга", "Последний шанс", "Ограниченный"),
                    amount = 18
                ),
                DeviceModel(
                    id = 9,
                    name = "Fitbit Charge 5",
                    time = 1633737600000,
                    tags = arrayListOf(""),
                    amount = 27
                ),
                DeviceModel(
                    id = 10,
                    name = "GoPro Hero 10",
                    time = 1633824000000,
                    tags = arrayListOf("Камера", "Эксклюзив"),
                    amount = 25
                )
            )
        }
    }
}
