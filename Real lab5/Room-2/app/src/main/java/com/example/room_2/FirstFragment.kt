package com.example.room_2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_frist.*
import kotlinx.android.synthetic.main.list_fragment.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FirstFragment : Fragment() {

    var list = ArrayList<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("FirstFragment", "FirstFragment")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("FirstFragment", "onCreateView")
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("FirstFragment", "onViewCreated")

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

        apiService.getTodos().enqueue(object : Callback<List<Todo>> {
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                t.message?.let { Log.e("Error", it) }
            }

            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.e("Response size: ", response.body()!!.size.toString() + "")
                list.addAll(response.body()!!)
                todo_list_recycler.layoutManager = LinearLayoutManager(activity)
                todo_list_recycler.adapter = context?.let { TodoListAdapter(list, it) }
            }
        })
//        val todos1 = ArrayList<Todo>()
//        for (i in 0..20){
//            todos1.add(Todo(i, i,"Title", false))
//        }

//        todo_list_recycler.layoutManager = LinearLayoutManager(activity)
//        todo_list_recycler.adapter = context?.let { TodoListAdapter(list, it) }

    }

}