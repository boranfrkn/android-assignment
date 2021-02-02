package com.arabam.android.assigment.service

import com.arabam.android.assigment.model.DetailModel
import com.arabam.android.assigment.model.ListModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class

ArabamAPIService {
    private val BASE_URL = "http://sandbox.arabamd.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(ArabamAPI::class.java)
    fun getList(): Single<List<ListModel>> {
        return api.getList()
    }
    fun getDetail(id: Int): Single<DetailModel>{
        return api.getDetail(id)
    }
}