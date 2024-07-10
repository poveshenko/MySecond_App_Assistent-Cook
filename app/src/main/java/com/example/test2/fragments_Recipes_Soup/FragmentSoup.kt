package com.example.test2.fragments_Recipes_Soup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.R
import com.example.test2.databinding.FragmentSoupBinding
import com.example.test2.fragments_Main.RecipesFragment


class FragmentSoup : Fragment() {
    private lateinit var binding: FragmentSoupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSoupBinding.inflate(inflater, container, false)


        // при нажатии на кнопку, переходим на фрагмент "супы"
        binding.apply {

            buttonBackSoup.setOnClickListener {
                val fragment = RecipesFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup1.setOnClickListener {
                val fragment = FragmentSoupNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSoup2.setOnClickListener {
                val fragment = FragmentSoupNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup3.setOnClickListener {
                val fragment = FragmentSoupNumber3()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup4.setOnClickListener {
                val fragment = FragmentSoupNumber4()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup5.setOnClickListener {
                val fragment = FragmentSoupNumber5()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup6.setOnClickListener {
                val fragment = FragmentSoupNumber6()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup7.setOnClickListener {
                val fragment = FragmentSoupNumber7()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup8.setOnClickListener {
                val fragment = FragmentSoupNumber8()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSoup9.setOnClickListener {
                val fragment = FragmentSoupNumber9()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }
        return binding.root
    }
}