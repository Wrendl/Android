package com.example.room_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CommentListAdapter(val comment: ArrayList<Comment> , val context: Context): RecyclerView.Adapter<CommentListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.comment_detail, parent, false)

        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return comment.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val comment = comment.get(position)
        holder.commentName.text = comment.name
        holder.commentEmail.text = comment.email
        holder.commentBody.text = comment.body
    }

    class MyViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){
        var commentName : TextView = view.findViewById(R.id.comment_name)
        var commentEmail : TextView = view.findViewById(R.id.comment_email)
        var commentBody : TextView = view.findViewById(R.id.comment_body)
    }

}