package com.example.hackernewsapp

import android.arch.persistence.room.*

@Dao
interface MyDao {

    @get:Query( "select * from news")
    val newss: List<News>


    @Query("select * from news")
     abstract  fun  getnews():List<News>

    @Insert
     abstract  fun  insertnews(newslist: News)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun  getMultinews(news: News)


    @Update
    fun  updatenews( news:News)



}