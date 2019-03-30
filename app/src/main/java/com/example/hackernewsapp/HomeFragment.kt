package com.example.hackernewsapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment(),View.OnClickListener {
    private lateinit var bnjob:Button
    private lateinit var bnnews:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        bnjob=view.findViewById(R.id.btnjob)
        bnnews= view.findViewById(R.id.btnnews)
        bnjob.setOnClickListener(this)
        bnnews.setOnClickListener(this)
        return view
    }
    override fun onClick(v: View?) {
        when(v?.id){
          // R.id.btnjob-> MainActivity.fragmentManager.beginTransaction().replace(R.id.mainfrag,JobFragment()).addToBackStack(null).commit()
          //R.id.btnnews->MainActivity.fragmentManager.beginTransaction().replace(R.id.mainfrag,NewsFragment()).addToBackStack(null).commit()
            R.id.btnnews->activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.linearlayout, NewsFragment())?.addToBackStack(null)?.commit()
            R.id.btnjob->activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.linearlayout, JobFragment())?.addToBackStack(null)?.commit()
        }
    }
}
