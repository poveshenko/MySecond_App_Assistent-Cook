package com.example.test2.fragments_Recipes_lunch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.R
import com.example.test2.databinding.FragmentLunchBinding
import com.example.test2.fragments_Main.RecipesFragment


class FragmentLunch : Fragment() {
    private lateinit var binding: FragmentLunchBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLunchBinding.inflate(inflater, container, false)

        binding.apply {

            buttonBackLunch.setOnClickListener {
                val fragment = RecipesFragment()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }


            frameLayoutLunch1.setOnClickListener {
                val fragment = FragmentLunchNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch2.setOnClickListener {
                val fragment = FragmentLunchNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch3.setOnClickListener {
                val fragment = FragmentLunchNumber3()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch4.setOnClickListener {
                val fragment = FragmentLunchNumber4()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch5.setOnClickListener {
                val fragment = FragmentLunchNumber5()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch6.setOnClickListener {
                val fragment = FragmentLunchNumber6()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch7.setOnClickListener {
                val fragment = FragmentLunchNumber7()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutLunch8.setOnClickListener {
                val fragment = FragmentLunchNumber8()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutLunch9.setOnClickListener {
                val fragment = FragmentLunchNumber9()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }
        return binding.root
    }
}