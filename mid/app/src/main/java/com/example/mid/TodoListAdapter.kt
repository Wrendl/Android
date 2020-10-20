package com.example.mid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class TodoListAdapter(val todos: ArrayList<Todo>, val context: Context) :
    RecyclerView.Adapter<TodoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_items, parent, false)
        return MyViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = todos.get(position)
        holder.titleText.text = todo.title
        holder.statusText.text = todo.status
        holder.categoryText.text = todo.category
    }

    class MyViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
        var titleText: TextView = view.findViewById(R.id.title)
        var statusText: TextView = view.findViewById(R.id.status)
        var categoryText: TextView = view.findViewById(R.id.category)
    }
}