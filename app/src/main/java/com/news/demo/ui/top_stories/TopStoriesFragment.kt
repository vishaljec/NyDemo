package com.news.demo.ui.top_stories


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.fanspec.ui.match.TopStoriesAdapter
import com.news.demo.App
import com.news.demo.R
import com.news.demo.data.entities.TopStory
import com.news.demo.ui.match.DaggerTopStoriesComponent
import com.news.demo.ui.match.TopStoriesContract
import com.news.demo.utils.ActivityUtils
import kotlinx.android.synthetic.main.top_stories.view.*
import javax.inject.Inject

class TopStoriesFragment : androidx.fragment.app.Fragment(), TopStoriesContract.View {

    @Inject
    lateinit var topStoriesPresenter: TopStoriesPresenter
    private lateinit var alertDialog: androidx.appcompat.app.AlertDialog
    private lateinit var fView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fView = inflater.inflate(R.layout.top_stories, container, false)

        injectDependencies()
        alertDialog = ActivityUtils.progressDialog(activity!!)
        topStoriesPresenter.attachView(this)

        loadData()
        return fView
    }


    private fun loadData() {
        if (ActivityUtils.isNetworkAvailable(activity!!))
            topStoriesPresenter.loadTSData()
        else
            Toast.makeText(activity, ActivityUtils.NETWORK_ERROR, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(home: TopStory) {
        alertDialog.dismiss()
        Log.d("", "'")

        var tsAdapter = TopStoriesAdapter(home.data!!, activity!!)
        fView.rv_top_story.adapter = tsAdapter
        var layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        fView.rv_top_story.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(fView.rv_top_story.context,
                layoutManager.orientation)
        fView.rv_top_story.addItemDecoration(dividerItemDecoration)

        /* Observable.fromCallable {
             var db = NYDatabase.getAppDataBase(activity!!.baseContext)
             var topStory = db?.topStoriesDao()
             var storyMultimedia = db?.storyMediaDao()

             with(topStory) {
                 for(i in 0 until home.data!!.size){
                     this?.insertTopStory(home.data!![i])
                     //storyMultimedia.insertStoryMultimedia(home.data!![i].multimedia)

                 }

                 //   storyMultimedia.insertTopStory()

             }
             topStory?.getAllTopStories()
         }.doOnNext { list ->
             var finalString = ""
             list?.map { finalString += it.title + " - " }
             Log.d("vishal", finalString)

         }.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe()*/

    }

    override fun showProgress() {
        alertDialog.show()
    }

    override fun hideProgress() {
        alertDialog.dismiss()
    }

    override fun showError(error: String) {
    }

    override fun injectDependencies() {
        val applicationComponent = (activity!!.application as App).applicationComponent
        DaggerTopStoriesComponent.builder()
                .applicationComponent(applicationComponent)
                .build()
                .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        topStoriesPresenter.detachView()
    }


}











