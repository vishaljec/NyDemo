package com.news.demo.ui.top_stories

import com.news.demo.data.NYServices
import com.news.demo.di.scopes.ActivityScope
import dagger.Module
import dagger.Provides

@Module
internal class TopStoriesModule {
    @ActivityScope
    @Provides
    fun provideTopStoriesPresenter(nyService: NYServices): TopStoriesPresenter {
        return TopStoriesPresenter(nyService)
    }
}