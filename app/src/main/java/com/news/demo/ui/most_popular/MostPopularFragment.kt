package com.news.demo.ui.most_popular


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.fanspec.ui.match.MostPopularAdapter
import com.android.fanspec.ui.match.TopStoriesAdapter
import com.news.demo.App
import com.news.demo.R
import com.news.demo.data.entities.MostPopular
import com.news.demo.ui.match.DaggerMostPopularComponent
import com.news.demo.ui.match.MostPopularContract
import com.news.demo.utils.ActivityUtils
import kotlinx.android.synthetic.main.top_stories.view.*
import javax.inject.Inject

class MostPopularFragment : androidx.fragment.app.Fragment(), MostPopularContract.View {

    @Inject
    lateinit var mostPopularPresenter: MostPopularPresenter
    private lateinit var alertDialog: androidx.appcompat.app.AlertDialog
    private lateinit var fView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fView = inflater.inflate(R.layout.top_stories, container, false)

        injectDependencies()
        alertDialog = ActivityUtils.progressDialog(activity!!)
        mostPopularPresenter.attachView(this)

        loadData()
        return fView
    }


    private fun loadData() {
        if (ActivityUtils.isNetworkAvailable(activity!!))
            mostPopularPresenter.loadMPData()
        else
            Toast.makeText(activity, ActivityUtils.NETWORK_ERROR, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(home: MostPopular) {
        alertDialog.dismiss()
        Log.d("", "'")

        var tsAdapter = MostPopularAdapter(home.data!!, activity!!)
        fView.rv_top_story.adapter = tsAdapter
        var layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        fView.rv_top_story.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(fView.rv_top_story.context,
                layoutManager.orientation)
        fView.rv_top_story.addItemDecoration(dividerItemDecoration)



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
        DaggerMostPopularComponent.builder()
                .applicationComponent(applicationComponent)
                .build()
                .inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mostPopularPresenter.detachView()
    }


}











