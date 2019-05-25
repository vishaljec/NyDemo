package com.news.demo.ui.most_popular

import com.news.demo.data.NYServices
import com.news.demo.data.entities.MostPopular
import com.news.demo.data.entities.TopStory
import com.news.demo.ui.match.MostPopularContract
import com.news.demo.utils.ExtensionUtils.void
import com.news.demo.utils.ExtensionUtils.voidBoolean
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


class MostPopularPresenter(var nyService: NYServices) : MostPopularContract.Presenter {

    private var view: MostPopularContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun loadMPData() {
        nyService.loadMPData(object : Observer<MostPopular> {
            override fun onComplete() = view?.hideProgress().void()
            override fun onNext(t: MostPopular) = view?.showResult(t).void()
            override fun onError(e: Throwable) = view?.showError(e.toString()).void()
            override fun onSubscribe(d: Disposable) = compositeDisposable.add(d).voidBoolean()
        })
        view?.showProgress()
    }

    override fun attachView(view: MostPopularContract.View) {
        this.view = view
    }

    override fun detachView() {
        compositeDisposable.dispose()
        this.view = null
    }

}