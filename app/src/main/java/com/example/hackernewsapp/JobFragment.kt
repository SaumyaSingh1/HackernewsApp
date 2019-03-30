package com.example.hackernewsapp


import android.nfc.Tag
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_job.*
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
class JobFragment : Fragment() {
    private  val gson=Gson()
    private  val joblist=ArrayList<Jobs>()
    private  var TAG=javaClass.simpleName
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val client=OkHttpClient()
        val request=Request.Builder().url(" https://hacker-news.firebaseio.com/v0/item/192327.json?print=pretty").build()
        val call=client.newCall(request)
        call.enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                client.newCall(request).enqueue(this)
            }

            override fun onResponse(call: Call, response: Response) {
               val result=response.body()?.string()
                val job=gson.fromJson<Jobs>(result,Jobs::class.java)
                 joblist.add(job)
            }
        })
        val jobsAdapter=JobAdapter(joblist,requireContext())
        rvjob.layoutManager=LinearLayoutManager(requireContext())
        rvjob.adapter=jobsAdapter
        jobsAdapter.notifyDataSetChanged()
    }
}
