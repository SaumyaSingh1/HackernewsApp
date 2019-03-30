package com.example.hackernewsapp


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.adapter_job.*
import kotlinx.android.synthetic.main.fragment_news.*
import okhttp3.*
import java.io.IOException


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NewsFragment : Fragment() {

    val db by lazy {
        Room.databaseBuilder(requireContext(),MyAppDatabase::class.java,"hackerdb.db").allowMainThreadQueries().build()
    }

     private val gson=Gson()
     private  val newslist=ArrayList<News>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val client=OkHttpClient()
        val request=Request.Builder().url(" https://hacker-news.firebaseio.com/v0/item/8863.json?print=pretty").build()
        val call=client.newCall(request)

               //check if the database is empty, if yes then update the news
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }
            override fun onResponse(call: Call, response: Response) {
             val result=response.body()?.string()
                val topnews=gson.fromJson<News>(result,News::class.java )
                newslist.add(topnews)
                //store the news in database
                 //get id of news stored
                  db.myDao().insertnews(topnews)
            }
        })
        val newsAdapter=NewsAdapter(newslist,requireContext())
        rvnews.adapter=newsAdapter
        rvnews.layoutManager=LinearLayoutManager(requireContext())
        newsAdapter.notifyDataSetChanged()
    }
}
