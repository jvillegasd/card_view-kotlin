package com.example.myapplicationrw


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplicationrw.data.User
import com.example.myapplicationrw.databinding.FragmentShowInfoBinding

/**
 * A simple [Fragment] subclass.
 */
class showInfo : Fragment() {

    lateinit var user : User
    lateinit var binder : FragmentShowInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = arguments!!.getParcelable("data")!!

        /*view.findViewById<TextView>(R.id.textView3).text = "Name: " + user.titulo + ' ' + user.nombre + ' ' + user.apellido
        view.findViewById<TextView>(R.id.lastn_tv).text = "Email: " + user.email
        view.findViewById<TextView>(R.id.textView2).text = "Phone: " + user.telefono*/

        binder = DataBindingUtil.setContentView(this.requireActivity(), R.layout.fragment_show_info)
        binder.user = user
    }


}
