package com.example.example_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.add_post.*

class ThirdFragment: Fragment() {

    var cnt: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        add.setOnClickListener{
            val userId = user_id_ET.text.toString().toInt()
            val id = MainActivity.list1.size
            val title = title_ET.text.toString()
            val body = body_ET.text.toString()

            var post = Post(userId,id,title,body)

            MainActivity.list1.add(post)

            it.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }
    }
}