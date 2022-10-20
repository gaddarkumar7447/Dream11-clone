package com.example.dream11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dream11.notification.Notification


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this,R.color.black)

        /*val actionBar: ActionBar?
        actionBar = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#F12727"))
        actionBar!!.setBackgroundDrawable(colorDrawable)*/

        /*val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "  Dream11"
        //actionBar?.subtitle = " "*/
        //actionBar?.setIcon(R.drawable.btn_radio)
        actionBar?.setDisplayUseLogoEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

        }
        return super.onOptionsItemSelected(item)
    }*/

    fun wallet(item: MenuItem) {
        Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
    }
    fun notification(item: MenuItem) {
        startActivity(Intent(this, Notification::class.java))
    }

}