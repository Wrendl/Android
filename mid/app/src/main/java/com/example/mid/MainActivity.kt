package com.example.mid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.first_fragment.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.first_fragment)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fragment1, FirstFragment())
//            .add(R.id.fragment2,SecondFragment())
//            .commit()

        var todos = ArrayList<Todo>()
        for ( i in 1..50){
            todos.add(Todo(1,"title"+i, "nice", "ok", "category"+(i*2), i*100))
        }

        val todoListAdapter = TodoListAdapter(todos, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = todoListAdapter
    }
}