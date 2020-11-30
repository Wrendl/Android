package com.example.room_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class TodoListAdapter(val todo: ArrayList<Todo> , val context: Context): RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_content, parent, false)

        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = todo.get(position)
        holder.todoTitle.text = todo.title
        holder.todoCompleted.text = todo.completed.toString()
    }

    class MyViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        var todoTitle : TextView = view.findViewById(R.id.todo_title)
        var todoCompleted : TextView = view.findViewById(R.id.todo_completed)

        init {
            view.setOnClickListener(){
                it.findNavController().navigate(R.id.fourthFragment)
            }
        }
    }

}