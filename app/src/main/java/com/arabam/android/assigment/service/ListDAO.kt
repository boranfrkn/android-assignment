package com.arabam.android.assigment.service

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.arabam.android.assigment.model.ListModel

@Dao
interface ListDAO {
    @Insert
    suspend fun insertAll(vararg listModel: ListModel) : List<Long>
    @Query("SELECT * FROM listModel")
    suspend fun getAllList() : List<ListModel>
    @Query("SELECT * FROM listModel WHERE id = id")
    suspend fun getList() : ListModel
    @Query("DELETE FROM listModel")
    suspend fun deleteAll()

}