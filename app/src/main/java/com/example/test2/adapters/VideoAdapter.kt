package com.example.test2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.databinding.ItemContainerVideoBinding

class VideoAdapter(private val videoItems: List<VideoItem>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {


    inner class VideoViewHolder(val binding: ItemContainerVideoBinding) : RecyclerView.ViewHolder(binding.root) {
        private val videoView: VideoView = binding.videoView
        private val textVideoTitle: TextView = binding.textVideoTitle
        private val textVideoDescription: TextView = binding.textVideoDescription
        private val pauseButton: ImageView = binding.pauseButton


        fun setVideoData(videoItem: VideoItem) {
            textVideoTitle.text = videoItem.videoTitle
            textVideoDescription.text = videoItem.videoDescription
            videoView.setVideoPath(videoItem.videoURL)

            videoView.setOnPreparedListener { mp ->
//ии
                mp.start()
                val videoRatio = mp.videoWidth / mp.videoHeight.toFloat()
                val screenRatio = videoView.width / videoView.height.toFloat()
                val scale = videoRatio / screenRatio
                if (scale >= 1f) {
                    videoView.scaleX = scale
                } else {
                    videoView.scaleY = 1f / scale
                }
            }
            videoView.setOnCompletionListener { mp ->
                mp.start()
            }
            pauseButton.setOnClickListener {
                if (videoView.isPlaying) {
                    videoView.pause()
                    pauseButton.setImageResource(R.drawable.pause)
                } else {
                    videoView.start()
                    pauseButton.setImageResource(R.drawable.play)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemContainerVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return videoItems.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.setVideoData(videoItems[position])

    }

}