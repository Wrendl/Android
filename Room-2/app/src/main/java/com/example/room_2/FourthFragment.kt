package com.example.room_2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.comment_list.*
import kotlinx.android.synthetic.main.fragment_fourth.*
import kotlinx.android.synthetic.main.list_fragment.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FourthFragment: Fragment() {

    var list1 = ArrayList<Comment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        list1.add(Comment(1,1,"name1","asd","asd"))
//        list1.add(Comment(1,2,"name2","asd","asd"))
//        list1.add(Comment(2,1,"name3","asd","asd"))
//        list1.add(Comment(2,2,"name4","asd","asd"))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.comment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val commentId = arguments?.getInt("commentId")
//        text.text = commentId.toString()

        if (commentId != null) {
            apiService.getCommentsById(commentId).enqueue(object : Callback<List<Comment>> {
                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                    t.message?.let { Log.e("Error", it) }
                }

                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                    Log.e("Response size: ", response.body()!!.size.toString() + "")
                    list1.addAll(response.body()!!)
                    comment_list_recycler.layoutManager = LinearLayoutManager(activity)
                    comment_list_recycler.adapter = context?.let { CommentListAdapter(list1, it) }
                }
            })
        }

//        comment_list_recycler.layoutManager = LinearLayoutManager(activity)
//        comment_list_recycler.adapter = context?.let { CommentListAdapter(list1, it) }
    }
}