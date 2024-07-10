package com.example.test2.fragments_Recipes_salad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber1
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber2
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber3
import com.example.test2.fragments_Recipes_salad.FragmentSaladNumber4
import com.example.test2.R
import com.example.test2.databinding.FragmentSaladBinding
import com.example.test2.fragments_Main.RecipesFragment


class FragmentSalad : Fragment() {
    private lateinit var binding: FragmentSaladBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSaladBinding.inflate(inflater, container, false)

        binding.apply {

            buttonBackSalad.setOnClickListener {
                val fragment = RecipesFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSalad1.setOnClickListener {
                val fragment = FragmentSaladNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSalad2.setOnClickListener {
                val fragment = FragmentSaladNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSalad3.setOnClickListener {
                val fragment = FragmentSaladNumber3()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSalad4.setOnClickListener {
                val fragment = FragmentSaladNumber4()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSalad5.setOnClickListener {
                val fragment = FragmentSaladNumber5()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSalad6.setOnClickListener {
                val fragment = FragmentSaladNumber6()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSalad7.setOnClickListener {
                val fragment = FragmentSaladNumber7()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutSalad8.setOnClickListener {
                val fragment = FragmentSaladNumber8()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSalad9.setOnClickListener {
                val fragment = FragmentSaladNumber9()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }


        }
        return binding.root
    }
}