package com.example.example_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.example_1.MainActivity.Companion.list1
import kotlinx.android.synthetic.main.list_fragment.*

class SecondFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        post_list_recycler.layoutManager = LinearLayoutManager(activity)
        post_list_recycler.adapter = context?.let { PostListAdapter(list1, it) }
    }

//    public fun addPost(post: Post){
//        list1.add(post)
//    }
}