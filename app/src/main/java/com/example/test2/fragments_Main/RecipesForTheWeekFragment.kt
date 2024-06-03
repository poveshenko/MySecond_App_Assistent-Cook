package com.example.test2.fragments_Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.test2.R
import com.example.test2.adapters.MyPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class RecipesForTheWeekFragment : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_recipes_for_the_week, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.myViewPager2)
        tabLayout = view.findViewById(R.id.myTabLayout)

        val pagerAdapter = MyPagerAdapter(parentFragmentManager, lifecycle)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Set tab text based on position
            when (position) {
                0 -> tab.text = "1"
                1 -> tab.text = "2"
                2 -> tab.text = "3"
                3 -> tab.text = "4"
                4 -> tab.text = "5"
            }
        }.attach()
    }

}