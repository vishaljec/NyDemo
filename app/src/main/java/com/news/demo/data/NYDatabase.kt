package com.news.demo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.news.demo.data.entities.Story
import com.news.demo.data.entities.StoryMultimedia
import com.news.demo.data.local.StoryMediaDao
import com.news.demo.data.local.TopStoryDao

//@Database(entities = [Story::class, StoryMultimedia::class], version = 2)
abstract class NYDatabase : RoomDatabase() {
    abstract fun topStoriesDao(): TopStoryDao
    abstract fun storyMediaDao(): StoryMediaDao

    companion object {
        var INSTANCE: NYDatabase? = null

        fun getAppDataBase(context: Context): NYDatabase? {
            if (INSTANCE == null) {
                synchronized(NYDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, NYDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            INSTANCE = null
        }
    }

}