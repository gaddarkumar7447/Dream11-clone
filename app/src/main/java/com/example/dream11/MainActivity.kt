package com.example.dream11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.dream11.bottomNavigation.*
import com.example.dream11.databinding.ActivityMainBinding
import com.example.dream11.fragments.PageAdapter
import com.example.dream11.notification.Notification
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener


class MainActivity : AppCompatActivity() {

    private lateinit var pageAdapter: PageAdapter
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        val tabLayout = findViewById<TabLayout>(R.id.include1)
        val viewPager = findViewById<ViewPager>(R.id.fragment_Container)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        pageAdapter = PageAdapter(supportFragmentManager, 7)
        viewPager.adapter = pageAdapter

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.my_matches -> replaceFragment(MyMatches())
                R.id.Rewards -> replaceFragment(Rewards())
                R.id.chats -> replaceFragment(Chats())
                R.id.winner -> replaceFragment(Winners())
                else -> {
                }
            }
            true
        }


    }

    fun wallet(item: MenuItem) {
        Toast.makeText(this, "Implemented soon..", Toast.LENGTH_LONG).show()
    }

    fun notification(item: MenuItem) {
        startActivity(Intent(this, Notification::class.java))
    }



    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}

