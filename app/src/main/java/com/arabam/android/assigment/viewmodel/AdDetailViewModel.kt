package com.arabam.android.assigment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arabam.android.assigment.model.DetailModel
import com.arabam.android.assigment.service.ArabamAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AdDetailViewModel() : ViewModel() {
    val detail = MutableLiveData<DetailModel>()
    private var apiService = ArabamAPIService()
    private var disposable = CompositeDisposable()

    fun loadDetail(id: Int){
        disposable.add(
                apiService.getDetail(id)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<DetailModel>(){
                            override fun onSuccess(t: DetailModel) {
                                detail.value = t
                            }

                            override fun onError(e: Throwable) {
                                e.printStackTrace()
                            }
                        })
        )
    }
}