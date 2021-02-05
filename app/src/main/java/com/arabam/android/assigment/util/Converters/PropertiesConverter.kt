package com.arabam.android.assigment.util.Converters

import androidx.room.TypeConverter
import com.arabam.android.assigment.model.PropertyList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PropertiesConverter {
    @TypeConverter
    fun fromProperties(properties : String): List<PropertyList> {
        val type = object : TypeToken<List<PropertyList>>(){}.type
        return Gson().fromJson(properties, type)
    }
    @TypeConverter
    fun toProperties(properties: List<PropertyList>) : String{
        val type = object : TypeToken<List<PropertyList>>(){}.type
        return Gson().toJson(properties, type)
    }
}

