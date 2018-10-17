package com.ceylonapz.kotalin

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(val context: Context, var namesList: ArrayList<String>) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_item, parent, false))
    }

    override fun getItemCount(): Int {
        return namesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userName = namesList.get(position)
        holder.nameTv.text = userName
        holder.userPhoto.setImageResource(R.mipmap.ic_launcher_round)

        holder.rowView.setOnClickListener { view ->
            Snackbar.make(view, "Clicked " + userName, Snackbar.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rowView = view
        val nameTv = view.nameText
        val userPhoto = view.userImage
    }
}