package com.news.demo.data.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName


data class TopStory(
        @SerializedName("status") var status: String? = null,
        @SerializedName("section") var successMessage: String? = null,
        @SerializedName("results") var data: List<Story>? = null)


//@Entity(tableName = "TopStory")
data class Story(@PrimaryKey(autoGenerate = true)
                 var id: Int? = 0,
                 @SerializedName("section") var section: String? = "",
                 @SerializedName("subsection") var subsection: String? = "",
                 @SerializedName("title") var title: String? = "",
                 @SerializedName("abstract") var abstract: String? = "",
                 @SerializedName("byline") var byline: String? = "",
                 @SerializedName("published_date") var published_date: String? = "",
                 @SerializedName("multimedia") var data: List<StoryMultimedia>? = null)

@Entity(indices = [Index("story")], foreignKeys = [ForeignKey(entity = Story::class,
        parentColumns = ["id"], childColumns = ["story"])])
data class StoryMultimedia(@PrimaryKey(autoGenerate = true)
                           var id: Int? = 0,
                           var story: Int? = 0,
                           @SerializedName("caption") var caption: String? = "",
                           @SerializedName("url") var url: String? = "",
                           @SerializedName("width") var width: String? = "",
                           @SerializedName("height") var height: String? = "",
                           @SerializedName("format") var format: String? = "")