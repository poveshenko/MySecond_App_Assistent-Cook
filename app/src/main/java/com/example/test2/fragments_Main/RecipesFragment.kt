package com.example.test2.fragments_Main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.fragments_Recipes_Soup.FragmentSoup
import com.example.test2.fragments_Recipes_lunch.FragmentLunch
import com.example.test2.fragments_Recipes_salad.FragmentSalad
import com.example.test2.fragments_Recipes_snacks.FragmentSnacks
import com.example.test2.R
import com.example.test2.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    //подключаем binding
    private lateinit var binding: FragmentRecipesBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater, container, false)


        // при нажатии на кнопку, переходим на фрагмент "супы"
        binding.apply {
            ButtonSoup.setOnClickListener {
                val fragment = FragmentSoup()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_recipes, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            ButtonSalad.setOnClickListener {
                val fragment = FragmentSalad()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_recipes, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            ButtonLunch.setOnClickListener {
                val fragment = FragmentLunch()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_recipes, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            ButtonSnacks.setOnClickListener {
                val fragment = FragmentSnacks()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_recipes, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }
        return binding.root
    }
}

