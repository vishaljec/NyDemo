package com.news.demo.ui.match

import com.news.demo.di.ApplicationComponent
import com.news.demo.di.scopes.ActivityScope
import com.news.demo.ui.top_stories.TopStoriesFragment
import com.news.demo.ui.top_stories.TopStoriesModule
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(TopStoriesModule::class))
internal interface TopStoriesComponent {
    fun inject(topStoriesFragment: TopStoriesFragment)
}
