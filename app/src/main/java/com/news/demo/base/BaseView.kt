package com.news.demo.base


interface BaseView {
    fun showError(error: String)
    fun injectDependencies()
}