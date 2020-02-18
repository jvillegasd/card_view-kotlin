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
        users.add(User("User 1", "U", "a@a.com", "123", "Mr."))
        users.add(User("User 2", "U", "a@a.com", "123", "Ms."))
        users.add(User("User 3", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 3", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 4", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 5", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 6", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 7", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 8", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 9", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 10", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 11", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 12", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 13", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 14", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 15", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 16", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 17", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 18", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 19", "U", "a@a.com", "123", "Mrs."))
        users.add(User("User 20", "U", "a@a.com", "123", "Mrs."))

        adapter = UserRecycledViewAdapter(users)
        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter
        return view
    }


}
