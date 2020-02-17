package com.example.myapplicationrw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationrw.data.User

class UserRecycledViewAdapter(private val mValue: List<User>) : RecyclerView.Adapter<UserRecycledViewAdapter.viewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserRecycledViewAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return mValue.size
    }

    override fun onBindViewHolder(holder: UserRecycledViewAdapter.viewHolder, position: Int) {
        val item = mValue[position]
        holder.textView.text = item.nombre
    }

    inner class viewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        val button : Button = mView.findViewById(R.id.buttonDeleteUser)
        val textView : TextView = mView.findViewById(R.id.textViewUserName)
    }
}