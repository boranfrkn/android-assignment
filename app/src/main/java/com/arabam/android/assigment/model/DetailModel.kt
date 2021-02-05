package com.arabam.android.assigment.model

data class DetailModel(
        val category: CategoryDetail,
        val date: String,
        val dateFormatted: String,
        val id: Int,
        val location: LocationDetail,
        val modelName: String,
        val photos: List<String>,
        val price: Int,
        val priceFormatted: String,
        val properties: List<PropertyDetail>,
        var text: String,
        val title: String,
        val userInfo: UserInfo
)

data class CategoryDetail(
    val id: Int,
    val name: String
)

data class LocationDetail(
    val cityName: String,
    val townName: String
)

data class PropertyDetail(
    val name: String,
    val value: String
)

data class UserInfo(
    val id: Int,
    val nameSurname: String,
    val phone: String,
    val phoneFormatted: String
)
