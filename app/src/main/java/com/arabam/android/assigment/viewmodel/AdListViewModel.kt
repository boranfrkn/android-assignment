package com.arabam.android.assigment.viewmodel


import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.arabam.android.assigment.model.ListModel
import com.arabam.android.assigment.service.ArabamAPIService
import com.arabam.android.assigment.service.ListDatabase
import com.arabam.android.assigment.util.SpecialSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class AdListViewModel(application: Application) : BaseViewModel(application){
    val list = MutableLiveData<List<ListModel>>()
    var updateTime = 5 * 60 * 1000 * 1000 * 1000L
    private val apiService = ArabamAPIService()
    private val disposable = CompositeDisposable()
    private val specialSharedPreferences = SpecialSharedPreferences(getApplication())

    fun refreshData(){
        val recordingTime = specialSharedPreferences.getTime()
        if(recordingTime != null && recordingTime != 0L && System.nanoTime() - recordingTime < updateTime){
            getDataFromSQLite()
        }else{
            getDataFromAPI()
        }
    }

    private fun getDataFromSQLite(){
        launch {
            val adList = ListDatabase(getApplication()).listDao().getAllList()
            showList(adList)
        }
    }

    private fun getDataFromAPI() {
        disposable.add(
            apiService.getList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ListModel>>(){
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onSuccess(t: List<ListModel>) {
                        saveSQLite(t)
                    }
                })
        )
    }

    private fun showList(t: List<ListModel>){
        list.value = t
    }

    private fun saveSQLite(t: List<ListModel>){
        launch {
            val dao = ListDatabase(getApplication()).listDao()
            dao.deleteAll()
            val idList = dao.insertAll(*t.toTypedArray())
            var i = 0
            while (i < t.size){
                t[i].adGetId = idList[i].toInt()
                i = i + 1
            }
            showList(t)
        }
        specialSharedPreferences.setTime(System.nanoTime())
    }
}