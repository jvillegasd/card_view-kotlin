package com.example.myapplicationrw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplicationrw.data.User
import com.example.myapplicationrw.databinding.FragmentShowInfoBinding

/**
 * A simple [Fragment] subclass.
 */
class showInfo : Fragment() {

    lateinit var user : User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binder : FragmentShowInfoBinding
        binder = DataBindingUtil.inflate(LayoutInflater.from(container?.context), R.layout.fragment_show_info, container,false)
        binder.executePendingBindings()
        return inflater.inflate(R.layout.fragment_show_info, container, false)
    }


}
