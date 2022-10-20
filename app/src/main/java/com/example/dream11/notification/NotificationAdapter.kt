package com.example.dream11.notification

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dream11.R

class NotificationAdapter(private val list : List<String>, private val date : List<Int>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textNotification.text = list[position].toString()
        holder.timeDate.text = date[position].toString().plus(" Day ago")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        val textNotification: TextView = view.findViewById<TextView>(R.id.textNotification)
        val timeDate: TextView = view.findViewById<TextView>(R.id.time)
    }
}