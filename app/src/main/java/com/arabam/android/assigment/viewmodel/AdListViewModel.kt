package com.arabam.android.assigment.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arabam.android.assigment.model.ListModel
import com.arabam.android.assigment.service.ArabamAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class AdListViewModel() : ViewModel(){
    val list = MutableLiveData<List<ListModel>>()
    private val apiService = ArabamAPIService()
    private val disposable = CompositeDisposable()

    fun loadData() {
        disposable.add(
            apiService.getList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ListModel>>(){
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onSuccess(t: List<ListModel>) {
                        list.value = t
                    }
                })
        )
    }
}