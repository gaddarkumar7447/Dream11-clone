package com.example.dream11.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dream11.MainActivity


class PageAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    private var tabCount = behavior

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Cricket()
            1 -> Kabaddi()
            2 -> Football()
            3 -> basketBall()
            4 -> BaseBall()
            5 -> HandBall()
            6 -> VolleyBall()
            else -> getItem(position)
        }
    }
}