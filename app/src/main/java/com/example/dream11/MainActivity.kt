package com.example.dream11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
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
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var actionBarToggle : ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)


        val tabLayout = findViewById<TabLayout>(R.id.include1)
        val viewPager = findViewById<ViewPager>(R.id.fragment_Container)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        drawerLayout = findViewById(R.id.drawer_layout)
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarToggle)
        actionBarToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarToggle.onOptionsItemSelected(item)){
            true
        }
        else super.onOptionsItemSelected(item)
    }
}

