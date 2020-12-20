package com.example.example_1

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.add_post.*
import kotlinx.android.synthetic.main.change_post.*


class FourthFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.change_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId = arguments?.getInt("id")

        var post = MainActivity.list1[postId!!]

        user_id_ET_1.setText(post.userId.toString())
        title_ET_1.setText(post.title)
        body_ET_1.setText(post.body)

        change.setOnClickListener{
            var userId = user_id_ET_1.text.toString().toInt()
            var id = post.id
            var title = title_ET_1.text.toString()
            var body = body_ET_1.text.toString()

            var post1 = Post(userId,id,title,body)

            MainActivity.list1[postId!!] = post1

            it.findNavController().navigate(R.id.action_fourthFragment_to_firstFragment)
        }
    }
}