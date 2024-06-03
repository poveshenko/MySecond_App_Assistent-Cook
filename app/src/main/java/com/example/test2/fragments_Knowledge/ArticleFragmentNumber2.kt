package com.example.test2.fragments_Knowledge

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import com.example.test2.R
import com.example.test2.databinding.FragmentArticleNumber2Binding


class ArticleFragmentNumber2 : Fragment() {

    private lateinit var binding: FragmentArticleNumber2Binding
    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleNumber2Binding.inflate(inflater, container, false)

        binding.ScrollArticleNum2.post {
            binding.ScrollArticleNum2.smoothScrollTo(0, 0)
        }
        videoView = binding.videoViewArticle2
        val packageName = requireContext().packageName
        val videoPath = "android.resource://$packageName/${R.raw.article_2_video}"
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true
        }

        binding.buttonStart.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
                binding.buttonStart.setImageResource(R.drawable.pause)
            } else {
                videoView.start()
                binding.buttonStart.setImageResource(R.drawable.play)
            }
        }

        return binding.root
    }
}