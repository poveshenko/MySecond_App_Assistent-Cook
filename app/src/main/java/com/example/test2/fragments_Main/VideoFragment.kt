package com.example.test2.fragments_Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.test2.R
import com.example.test2.adapters.VideoAdapter
import com.example.test2.adapters.VideoItem
import com.example.test2.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {


    private lateinit var binding: FragmentVideoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVideoBinding.inflate(inflater, container, false)



        binding.apply {


            val videoItems = ArrayList<VideoItem>()

            val videoItemMyVideo = VideoItem(
                "android.resource://" + requireContext().packageName + "/" + R.raw.video,
                "Миниатюрный бургер",
                "Для ценителей "
            )
            videoItems.add(videoItemMyVideo)


            val videoItemMyVideo2 = VideoItem(
                "android.resource://" + requireContext().packageName + "/" + R.raw.video2,
                "Бургер как в МакДональдз",
                "Парни старались "
            )
            videoItems.add(videoItemMyVideo2)


            videoViewPager.adapter = VideoAdapter(videoItems)

        }

        return binding.root
    }
}
