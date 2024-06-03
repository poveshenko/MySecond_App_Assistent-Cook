package com.example.test2.fragments_Knowledge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test2.databinding.FragmentArticleNumber1Binding


class ArticleFragmentNumber1 : Fragment() {

    private lateinit var binding: FragmentArticleNumber1Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleNumber1Binding.inflate(inflater, container, false)
binding.apply {

}

        return binding.root
    }
}