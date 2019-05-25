package com.news.demo.ui.match

import com.news.demo.base.BasePresenter
import com.news.demo.base.BaseView
import com.news.demo.data.entities.MostPopular
import com.news.demo.data.entities.TopStory

interface MostPopularContract {
    interface View : BaseView {
        fun showResult(home: MostPopular)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun loadMPData()
    }
}