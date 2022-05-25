package com.example.dreamcake.data.model

data class Order(
    val name: String = "",
    var price: Double = 0.00,
    val description: String = "",
    val image: String = "",
    var available_amount: Int = 0
)