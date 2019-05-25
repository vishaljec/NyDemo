package com.news.demo.data.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName


data class MostPopular(
        @SerializedName("status") var status: String? = null,
        @SerializedName("section") var successMessage: String? = null,
        @SerializedName("results") var data: List<MPStory>? = null)


//@Entity(tableName = "TopStory")
data class MPStory(
        @SerializedName("section") var section: String? = "",
        @SerializedName("subsection") var subsection: String? = "",
        @SerializedName("title") var title: String? = "",
        @SerializedName("abstract") var abstract: String? = "",
        @SerializedName("byline") var byline: String? = "",
        @SerializedName("published_date") var published_date: String? = "",
        @SerializedName("media") var data: List<MYMultimedia>? = null)

data class MYMultimedia(
        @SerializedName("type") var type: String? = "",
        @SerializedName("media-metadata") var data: List<MediaMetaData>? = null)

data class MediaMetaData(
        @SerializedName("url") var url: String? = "",
        @SerializedName("width") var width: String? = "",
        @SerializedName("height") var height: String? = "",
        @SerializedName("format") var format: String? = "")