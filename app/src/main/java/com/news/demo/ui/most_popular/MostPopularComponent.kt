package com.news.demo.ui.match

import com.news.demo.di.ApplicationComponent
import com.news.demo.di.scopes.ActivityScope
import com.news.demo.ui.most_popular.MostPopularFragment
import com.news.demo.ui.most_popular.MostPopularModule
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MostPopularModule::class))
internal interface MostPopularComponent {
    fun inject(mostPopularFragment: MostPopularFragment)
}
