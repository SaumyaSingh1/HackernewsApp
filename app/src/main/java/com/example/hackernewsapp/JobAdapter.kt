package com.example.hackernewsapp

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_job.view.*

class  JobAdapter ( private  val jobslist: ArrayList<Jobs> , private  val context:Context):RecyclerView.Adapter<JobAdapter.JobHolder >(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): JobHolder {
      return JobHolder(LayoutInflater.from(context).inflate(R.layout.adapter_job, p0,false))
    }

    override fun getItemCount(): Int {
       return jobslist.size
    }

    override fun onBindViewHolder(p0: JobHolder, p1: Int) {
       val currentjob=jobslist[p1]
        with(p0.itemView){
           texts.text=currentjob.text
            title.text=currentjob.title
            url.text=currentjob.url
        }
    }


    class JobHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    }
}