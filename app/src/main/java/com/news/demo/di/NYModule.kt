package com.news.demo.di

import com.news.demo.data.NYServices
import com.news.demo.data.remote.RetrofitManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Module
class NYModule {
    @Singleton
    @Provides
    fun provideNY(fanSpecService: RetrofitManager.NYService): NYServices {
        return NYServices(fanSpecService)
    }
}