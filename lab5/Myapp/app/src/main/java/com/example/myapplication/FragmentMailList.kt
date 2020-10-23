package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.mail_list_fragment.*

class FragmentMailList: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mail_list_fragment,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mails = ArrayList<Mail>()
        for (i in 0..20){
            mails.add(Mail("Name Surname "+i, "Title"+i, "Good evening!"))
        }


        mail_list_recycler.layoutManager = LinearLayoutManager(activity)
        mail_list_recycler.adapter = context?.let { MailListAdapter(mails, it) }





    }
}