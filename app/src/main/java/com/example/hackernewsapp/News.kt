package com.example.hackernewsapp

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "news")
 public  class News( @ColumnInfo (name = "newstitle") var  title:String?,
    @ColumnInfo(name = "newsurl") var url:String? ,
 @PrimaryKey(autoGenerate = true)
    var id: Int = 0)

