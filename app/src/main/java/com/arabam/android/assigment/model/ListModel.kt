package com.arabam.android.assigment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity()
data class ListModel(
    @ColumnInfo(name = "category")
    @SerializedName("category")
    val category: CategoryList,
    @ColumnInfo(name = "date")
    @SerializedName("date")
    val date: String,
    @ColumnInfo(name = "dateFormatted")
    @SerializedName("dateFormatted")
    val dateFormatted: String,
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @PrimaryKey
    var adGetId: Int,
    @ColumnInfo(name = "location")
    @SerializedName("location")
    val location: LocationList,
    @ColumnInfo(name = "modelName")
    @SerializedName("modelName")
    val modelName: String,
    @ColumnInfo(name = "photo")
    @SerializedName("photo")
    val photo: String,
    @ColumnInfo(name = "price")
    @SerializedName("price")
    val price: Int,
    @ColumnInfo(name = "priceFormatted")
    @SerializedName("priceFormatted")
    val priceFormatted: String,
    @ColumnInfo(name = "properties")
    @SerializedName("properties")
    val properties: List<PropertyList>,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
)

@Entity
data class CategoryList(
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String
)

@Entity
data class LocationList(
    @ColumnInfo(name = "cityName")
    @SerializedName("cityName")
    val cityName: String,
    @ColumnInfo(name = "townName")
    @SerializedName("townName")
    val townName: String
)

@Entity
data class PropertyList(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "value")
    @SerializedName("value")
    val value: String
)