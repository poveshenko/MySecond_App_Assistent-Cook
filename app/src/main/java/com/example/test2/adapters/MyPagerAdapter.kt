package com.example.test2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test2.fragments_Home.FragmentPage1
import com.example.test2.fragments_Home.FragmentPage2
import com.example.test2.fragments_Home.FragmentPage3
import com.example.test2.fragments_Home.FragmentPage4
import com.example.test2.fragments_Home.FragmentPage5

class MyPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 5

    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> FragmentPage1()
            1 -> FragmentPage2()
            2 -> FragmentPage3()
            3 -> FragmentPage4()
            4 -> FragmentPage5()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

}