package com.arabam.android.assigment.model


data class ListModel(
    val category: Category,
    val date: String,
    val dateFormatted: String,
    var id: Int,
    val location: Location,
    val modelName: String,
    val photo: String,
    val price: Int,
    val priceFormatted: String,
    val properties: List<Property>,
    val title: String
)

data class Category(
    val id: Int,
    val name: String
)

data class Location(
    val cityName: String,
    val townName: String
)

data class Property(
    val name: String,
    val value: String
)