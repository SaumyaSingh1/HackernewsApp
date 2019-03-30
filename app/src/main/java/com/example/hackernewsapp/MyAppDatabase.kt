package com.example.hackernewsapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database( entities = [News::class], version = 1 )

 abstract  class  MyAppDatabase : RoomDatabase(){
    abstract fun myDao() :MyDao

}