package com.example.test2.activities


import com.example.test2.fragments_Main.HomeFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.test2.R
import com.example.test2.databinding.ActivityMainMenuBinding
import com.example.test2.fragments_Main.KnowledgeFragment
import com.example.test2.fragments_Main.RecipesFragment
import com.example.test2.fragments_Main.VideoFragment




class MainMenu : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val videoFragment = VideoFragment()
    private val knowledgeFragment = KnowledgeFragment()
   // private val wishesFragment  = WishesFragment()
    private val recipesFragment = RecipesFragment()

lateinit var binding:ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)



        setContentView(binding.root)






//Подключение Ниженего меню
        binding.bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.video -> replaceFragment(videoFragment)
                R.id.recipes -> replaceFragment(recipesFragment)
                R.id.knowledge -> replaceFragment(knowledgeFragment)
             //   R.id.wishes -> replaceFragment(wishesFragment)

            }
            true
        }



        replaceFragment(homeFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()


    }
}