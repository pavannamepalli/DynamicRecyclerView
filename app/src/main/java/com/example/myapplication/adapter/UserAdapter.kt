package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.Data

class UserAdapter(val c: Context, val userList: ArrayList<Data>):RecyclerView.Adapter<UserAdapter.UserViewHolder>()
{



    inner class UserViewHolder(val v: View): RecyclerView.ViewHolder(v){
        var name: TextView
        var mbNum: TextView

        init {
            name = v.findViewById<TextView>(R.id.mTitle)
            mbNum = v.findViewById<TextView>(R.id.mSubTitle)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v  = inflater.inflate(R.layout.list_item,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val newList = userList[position]
        holder.name.text = newList.useremail
        holder.mbNum.text = newList.userph
    }

    override fun getItemCount(): Int {
        return  userList.size
    }
}