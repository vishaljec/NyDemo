package com.android.fanspec.ui.match

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.news.demo.R
import com.news.demo.data.entities.Story
import kotlinx.android.synthetic.main.top_stories_item.view.*
import com.bumptech.glide.request.RequestOptions



class TopStoriesAdapter(private val story: List<Story>, context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<TopStoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.top_stories_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(story[position])

    override fun getItemCount(): Int = story.size

    inner class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        //private var customRunnable: CustomRunnable = CustomRunnable(myHandler, view.remaining_time, 10000)

        fun bind(story: Story) = with(itemView) {
          if(story.data!!.isNotEmpty()){
              val requestOptions = RequestOptions()
              requestOptions.placeholder(R.mipmap.thum)
              requestOptions.error(R.mipmap.thum)
              Glide.with(context)
                      .load(story.data!![story.data!!.size-1].url)
                      .apply(requestOptions)
                      .into(iv)
          }

            tv_title.text = story.title
            tv_abstract.text = story.abstract


        }
    }
}