package com.arabam.android.assigment.service

import com.arabam.android.assigment.model.ListModel
import io.reactivex.Single
import retrofit2.http.GET
import com.arabam.android.assigment.model.DetailModel
import retrofit2.http.Query

interface ArabamAPI {
    @GET("api/v1/listing?sort=1&sortDirection=0&take=10")
    fun getList(): Single<List<ListModel>>
    @GET("api/v1/detail?")
    fun getDetail(@Query("id") id: Int): Single<DetailModel>
}