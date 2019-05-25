package com.news.demo

import android.app.Application
import com.news.demo.di.ApplicationComponent
import com.news.demo.di.DaggerApplicationComponent
import com.news.demo.di.NYModule
import com.news.demo.di.NetworkModule



class App : Application() {
    var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

      applicationComponent = DaggerApplicationComponent.builder()
                .networkModule(NetworkModule())
                .nYModule(NYModule())
                .build()

    }
}
