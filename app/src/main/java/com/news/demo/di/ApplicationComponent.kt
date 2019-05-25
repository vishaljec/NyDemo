package com.news.demo.di

import com.news.demo.data.NYServices
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(NetworkModule::class, NYModule::class))
interface ApplicationComponent {
    fun NYAppService(): NYServices
}