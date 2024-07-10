package com.example.test2.fragments_Recipes_snacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber1
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber2
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber3
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber4
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber5
import com.example.test2.fragments_Recipes_snacks.FragmentSnackNumber6
import com.example.test2.R
import com.example.test2.databinding.FragmentSnacksBinding
import com.example.test2.fragments_Main.RecipesFragment


class FragmentSnacks : Fragment() {

    private lateinit var binding: FragmentSnacksBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSnacksBinding.inflate(inflater, container, false)

        binding.apply {

            buttonBackSnack.setOnClickListener {
                val fragment = RecipesFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }


            frameLayoutSnack1.setOnClickListener {
                val fragment = FragmentSnackNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSnack2.setOnClickListener {
                val fragment = FragmentSnackNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSnack3.setOnClickListener {
                val fragment = FragmentSnackNumber3()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSnack4.setOnClickListener {
                val fragment = FragmentSnackNumber4()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSnack5.setOnClickListener {
                val fragment = FragmentSnackNumber5()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSnack6.setOnClickListener {
                val fragment = FragmentSnackNumber6()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }
        return binding.root
    }
}