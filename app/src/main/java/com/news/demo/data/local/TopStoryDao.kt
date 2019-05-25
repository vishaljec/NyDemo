package com.news.demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.news.demo.data.entities.Story

@Dao
interface TopStoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopStories(topStories: List<Story>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopStory(topStories: Story)

    @Query("DELETE FROM TopStory")
    fun deleteAllTopStories()

    @Query("SELECT *FROM TopStory")
    fun getAllTopStories(): List<Story>

}