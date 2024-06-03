package com.example.test2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.test2.dataBase.CommentModel
import com.example.test2.R

class CommentAdapter(private var comments: List<CommentModel>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_list, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: CommentModel) {
            itemView.findViewById<TextView>(R.id.textNameComment).text = comment.name
            itemView.findViewById<TextView>(R.id.textComment).text = comment.textComment
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(comments: List<CommentModel>) {
        this.comments = comments
        notifyDataSetChanged()
    }
}



