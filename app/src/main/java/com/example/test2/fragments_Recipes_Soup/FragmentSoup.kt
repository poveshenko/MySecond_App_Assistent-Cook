package com.example.test2.fragments_Recipes_Soup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.R
import com.example.test2.databinding.FragmentSoupBinding


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
            frameLayoutSoup1.setOnClickListener {
                val fragment = FragmentSoupNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_soup, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
            frameLayoutSoup2.setOnClickListener {
                val fragment = FragmentSoupNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_soup, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }
        return binding.root
    }
}