package com.example.dream11

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class Notification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        window.statusBarColor = ContextCompat.getColor(this,R.color.red)

       /*val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setLogo(R.drawable.ic_baseline_keyboard_backspace_24)*/

        /*toolbar.setNavigationIcon(R.drawable.ic_good)
        toolbar.setTitle("Title")
        toolbar.setSubtitle("Sub")
        toolbar.setLogo(R.drawable.ic_launcher)
        setSupportActionBar(toolbar)*/
    }

    fun back(view: View) {
        onBackPressed()
    }
}