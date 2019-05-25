package com.news.demo.ui.most_popular

import com.news.demo.data.NYServices
import com.news.demo.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
internal class MostPopularModule {
    @ActivityScope
    @Provides
    fun provideTopStoriesPresenter(nyService: NYServices): MostPopularPresenter {
        return MostPopularPresenter(nyService)
    }
}