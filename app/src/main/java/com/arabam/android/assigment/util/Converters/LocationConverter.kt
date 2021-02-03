package com.arabam.android.assigment.util.Converters

import androidx.room.TypeConverter
import com.arabam.android.assigment.model.LocationList
import org.json.JSONObject

class LocationConverter {
    @TypeConverter
    fun fromLocation(location: LocationList) : String{
        return JSONObject().apply {
            put("cityName", location.cityName)
            put("townName", location.townName)
        }.toString()
    }
    @TypeConverter
    fun toLocation(location : String) : LocationList{
        val json = JSONObject(location)
        return LocationList(json.get("cityName") as String, json.get("townName") as String)
    }
}