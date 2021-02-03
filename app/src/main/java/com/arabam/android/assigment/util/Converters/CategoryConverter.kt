package com.arabam.android.assigment.util.Converters

import androidx.room.TypeConverter
import com.arabam.android.assigment.model.CategoryList
import org.json.JSONObject

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: CategoryList) : String{
        return JSONObject().apply {
            put("id", category.id)
            put("name", category.name)
        }.toString()
    }
    @TypeConverter
    fun toCategory(category: String): CategoryList{
        val json = JSONObject(category)
        return CategoryList(json.get("id") as Int, json.get("name") as String)
    }
}