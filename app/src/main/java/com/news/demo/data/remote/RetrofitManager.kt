package com.news.demo.data.remote

import com.news.demo.data.entities.*
import io.reactivex.Observable
import retrofit2.http.*


object RetrofitManager {

    const val NY_BASE_URL: String = " https://api.nytimes.com/svc/"

    interface NYService {
        @GET("topstories/v2/home.json?api-key=JY3LAfb8At5A2wqckdZErAYWAGWzm4TL")
        fun topStories(): Observable<TopStory>


        @GET("mostpopular/v2/emailed/7.json?api-key=JY3LAfb8At5A2wqckdZErAYWAGWzm4TL")
        fun popularStories(): Observable<MostPopular>

    }


}