package com.example.dream11.notification

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dream11.R
import com.google.android.material.snackbar.Snackbar


class Notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        window.statusBarColor = ContextCompat.getColor(this, R.color.red)
        val recyclerView = findViewById<RecyclerView>(R.id.notificationView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listO = listOf<String>("You've got a 100% discount! This special offer expire soon!","You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!","You've got a 100% discount! This special offer expire soon!",
            "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!","You've got a 100% discount! This special offer expire soon!",
            "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!",
            "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!","You've got a 100% discount! This special offer expire soon!",
            "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!", "You've got a 100% discount! This special offer expire soon!","You've got a 100% discount! This special offer expire soon!")
        val listO1 = listOf<Int>(1,4,3,4,3,2,1,8,6,4,2,4,1,5,2,4,9,4,5,7,3)

        val adapter = NotificationAdapter(listO, listO1)
        recyclerView.adapter = adapter
    }

    fun back(view: View) {
        onBackPressed()
    }

    fun snakbarShow(view: View) {
        val snackbar = Snackbar.make(view, "Mark all notification read.", Snackbar.LENGTH_LONG).show()

    }
    fun filter(view: View) {
        val snackbar = Snackbar.make(view, "Filter implemented soon...", Snackbar.LENGTH_LONG).show()
    }
}