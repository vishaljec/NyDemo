package com.news.demo.base


interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}