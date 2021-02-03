package com.arabam.android.assigment.util.Converters

import androidx.room.TypeConverter
//import com.arabam.android.assigment.model.PropertyList
import org.json.JSONObject

class PropertiesConverter {/*
    @TypeConverter
    fun fromProperties(properties : PropertyList): String {
        return JSONObject().apply {
            put("name", properties.name)
            put("value", properties.value)
        }.toString()
    }
    @TypeConverter
    fun toProperties(properties: String) : PropertyList{
        val json = JSONObject(properties)
        return PropertyList(json.get("name") as String, json.get("value") as String)
    }
    //Properties converter çalışmadı, yarın bu halledildikten sonra paging öğrenilecek.*/
}

