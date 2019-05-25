package com.news.demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.news.demo.data.entities.StoryMultimedia

@Dao
interface StoryMediaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoryMultimedias(storyMultimedia: List<StoryMultimedia>)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStoryMultimedia(storyMultimedia: StoryMultimedia)

    @Query("DELETE FROM StoryMultimedia")
    fun deleteAllStoryMultimedia()

    @Query("SELECT *FROM StoryMultimedia where story==:story")
    fun getStoryMultimedia(story: Int): List<StoryMultimedia>


}