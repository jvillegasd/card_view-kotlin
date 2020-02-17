package com.example.myapplicationrw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationrw.data.User
import kotlinx.android.synthetic.main.fragment_frag_rv.view.*

/**
 * A simple [Fragment] subclass.
 */
class frag_rv : Fragment() {

    val users = mutableListOf<User>()
    private var adapter : UserRecycledViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_frag_rv, container, false)
        users.add(User("User 1", "U", "a@a.com", "123"))
        users.add(User("User 2", "U", "a@a.com", "123"))
        users.add(User("User 3", "U", "a@a.com", "123"))
        adapter = UserRecycledViewAdapter(users)
        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter
        return view
    }


}
