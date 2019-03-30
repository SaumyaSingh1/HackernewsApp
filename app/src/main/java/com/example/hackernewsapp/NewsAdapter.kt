package com.example.hackernewsapp

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_news.view.*

class NewsAdapter(val newslist:ArrayList<News>,val context: Context):RecyclerView.Adapter<NewsAdapter.NewsHolder >(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(context).inflate(R.layout.adapter_news,p0,false))
    }

    override fun getItemCount(): Int {
    return  newslist.size
    }

    override fun onBindViewHolder(p0: NewsHolder, p1: Int) {
    val currentnews=newslist[p1]
        with(p0.itemView){
            newstitle.text=currentnews.title
            newsurl.text=currentnews.url
        }
    }

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}