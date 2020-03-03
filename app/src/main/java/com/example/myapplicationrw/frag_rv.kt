package com.example.myapplicationrw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.myapplicationrw.data.User
import com.example.myapplicationrw.data.randomUser
import com.google.android.material.internal.NavigationMenu
import kotlinx.android.synthetic.main.fragment_frag_rv.view.*

/**
 * A simple [Fragment] subclass.
 */
class frag_rv : Fragment(), UserRecycledViewAdapter.onListInteractions {

    val users = mutableListOf<User>()
    private var adapter : UserRecycledViewAdapter? = null
    lateinit var navController: NavController
    private lateinit var viewModel: RandomUserViewModel
    private var userList = mutableListOf<randomUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_frag_rv, container, false)
        /*users.add(User("User 1", "U", "a@a.com", "123", "Mr.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 2", "U", "a@a.com", "123", "Ms.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 3", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 3", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 4", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 5", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 6", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 7", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 8", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 9", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 10", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 11", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 12", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 13", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 14", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 15", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 16", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 17", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 18", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 19", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        users.add(User("User 20", "U", "a@a.com", "123", "Mrs.", "https://randomuser.me/api/portraits/women/72.jpg"))
        */
        viewModel = ViewModelProvider(this).get(RandomUserViewModel::class.java)
        viewModel.addUsers()


        VolleySingleton.getInstance(activity!!.applicationContext).addToRequestQueue(getStringRequest())

        adapter = UserRecycledViewAdapter(users, this)

        loadData()

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

    }

    override fun onListItemInteraction(item: User?) {

    }

    override fun onListButtonInteraction(item: User?) {
        val bundle = bundleOf("data" to item,"nombre" to item!!.nombre)
        navController!!.navigate(R.id.action_frag_rv_to_showInfo, bundle)
        println("click " + item!!.nombre)
    }

    fun loadData() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer { obsUsers ->
            run {
                userList = obsUsers as MutableList<randomUser>

                for(randUser in userList) {
                    var user = User(
                        randUser.name.first, randUser.name.last,
                        randUser.email, randUser.phone,randUser.name.title,randUser.picture.large
                    )
                    users.add(user)
                }
                adapter!!.updateData()
            }
        })
    }

    fun getStringRequest() : StringRequest {
        val url = "https://randomuser.me/api/?results=20"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                println(response)
            },
            Response.ErrorListener {
                println("error")
            }
        )

        return stringRequest
    }


}
