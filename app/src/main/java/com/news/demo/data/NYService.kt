package com.news.demo.data

import com.news.demo.data.entities.MostPopular
import com.news.demo.data.entities.TopStory
import com.news.demo.data.remote.RetrofitManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NYServices(private val service: RetrofitManager.NYService) {


    fun loadTSData(observer: Observer<TopStory>) {
        service.topStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

    fun loadMPData(observer: Observer<MostPopular>) {
        service.popularStories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }


}