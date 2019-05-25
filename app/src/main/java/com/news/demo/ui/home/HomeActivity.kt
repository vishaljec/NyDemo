package com.news.demo.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.news.demo.R
import com.news.demo.ui.top_stories.TopStoriesFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TabHost.OnTabChangeListener
import com.google.android.material.tabs.TabLayout
import com.news.demo.ui.most_popular.MostPopularFragment


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customToolbar()

        tabClick()


        addDifferentGameTabs()

    }


    private fun customToolbar() {
        var toolbar: Toolbar = toolbar as Toolbar
        setSupportActionBar(toolbar)
        ///supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //supportActionBar?.setDisplayShowHomeEnabled(true)
        //toolbar.?.setColorFilter(resources.getColor(R.color.colorAccent), PorterDuff.Mode.SRC_ATOP)
        toolbar.contentInsetStartWithNavigation = 0
    }

    private fun addDifferentGameTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("TOP STORIES"))
        tabLayout.addTab(tabLayout.newTab().setText("MOST POPULAR"))
        tabLayout.addTab(tabLayout.newTab().setText("OPINION"))
        tabLayout.addTab(tabLayout.newTab().setText("WORLD"))
        tabLayout.addTab(tabLayout.newTab().setText("US"))
    }

    private fun fragmentTransition(fragment: androidx.fragment.app.Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun tabClick() {


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        fragmentTransition(TopStoriesFragment())
                    }
                    1 -> {
                        fragmentTransition(MostPopularFragment())
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }

}