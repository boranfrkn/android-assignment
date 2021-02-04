package com.arabam.android.assigment.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arabam.android.assigment.model.ListModel
import com.arabam.android.assigment.util.Converters.CategoryConverter
import com.arabam.android.assigment.util.Converters.LocationConverter
import com.arabam.android.assigment.util.Converters.PropertiesConverter

@Database(entities = arrayOf(ListModel::class), version = 2)
@TypeConverters(CategoryConverter::class, LocationConverter::class, PropertiesConverter::class)

abstract class ListDatabase : RoomDatabase(){
    abstract fun listDao() : ListDAO

    companion object{
        @Volatile private var instance : ListDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, ListDatabase::class.java, "listdatabase").fallbackToDestructiveMigration().build()
    }
}