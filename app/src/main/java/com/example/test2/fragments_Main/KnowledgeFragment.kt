package com.example.test2.fragments_Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test2.fragments_Knowledge.ArticleFragmentNumber1
import com.example.test2.fragments_Knowledge.ArticleFragmentNumber2
import com.example.test2.fragments_Knowledge.ArticleFragmentNumber3
import com.example.test2.R
import com.example.test2.databinding.FragmentKnowledgeBinding


class KnowledgeFragment : Fragment() {
    private lateinit var binding: FragmentKnowledgeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKnowledgeBinding.inflate(inflater, container, false)










        binding.apply {

            frameLayoutArticle1.setOnClickListener {

                val fragment = ArticleFragmentNumber1()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_knowledge, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }


        frameLayoutArticle2.setOnClickListener {

                val fragment = ArticleFragmentNumber2()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_knowledge, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }

            frameLayoutArticle3.setOnClickListener {

                val fragment = ArticleFragmentNumber3()
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container_knowledge, fragment)
                transaction.addToBackStack(null) // Добавляем этот фрагмент в back stack
                transaction.commit()
            }
        }













        return binding.root
    }

}