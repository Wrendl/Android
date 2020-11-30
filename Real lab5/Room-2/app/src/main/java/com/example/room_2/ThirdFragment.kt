package com.example.room_2

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_frist.*

class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager?.beginTransaction()?.add(R.id.todo_list, FirstFragment())?.commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("ThirdFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_frist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        go_to_second.setOnClickListener {
            it.findNavController().navigate(R.id.action_thirdFragment2_to_secondFragment)
        }
    }


}