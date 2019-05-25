package com.news.demo.ui.top_stories

import com.news.demo.data.NYServices
import com.news.demo.data.entities.TopStory
import com.news.demo.ui.match.TopStoriesContract
import io.reactivex.Observer
import com.news.demo.utils.ExtensionUtils.void
import com.news.demo.utils.ExtensionUtils.voidBoolean
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


class TopStoriesPresenter(var nyService: NYServices) : TopStoriesContract.Presenter {

    private var view: TopStoriesContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun loadTSData() {
        nyService.loadTSData(object : Observer<TopStory> {
            override fun onComplete() = view?.hideProgress().void()
            override fun onNext(t: TopStory) = view?.showResult(t).void()
            override fun onError(e: Throwable) = view?.showError(e.toString()).void()
            override fun onSubscribe(d: Disposable) = compositeDisposable.add(d).voidBoolean()
        })
        view?.showProgress()
    }

    override fun attachView(view: TopStoriesContract.View) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

}