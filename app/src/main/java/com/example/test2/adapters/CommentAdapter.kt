package com.example.test2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R


import com.example.test2.dataBase.CommentModel
import com.example.test2.dataBase.FirebaseService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommentAdapter(
    private var comments: List<CommentModel>,
    private val firebaseService: FirebaseService
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    private var editableComment: CommentModel? = null
    private var editablePosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_list, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        if (editablePosition == position) {
            holder.bindEditable(comment)
        } else {
            holder.bind(comment)
        }
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val editTextComment: EditText = itemView.findViewById(R.id.editTextComment)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
        private val editButton: ImageButton = itemView.findViewById(R.id.editButton)
        private val saveButton: ImageButton = itemView.findViewById(R.id.saveButton)

        fun bind(comment: CommentModel) {
            itemView.findViewById<TextView>(R.id.textNameComment).text = comment.name
            editTextComment.setText(comment.textComment)
            editTextComment.isEnabled = false

            deleteButton.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    firebaseService.deleteComment(comment)
                    updateComments()
                }
            }

            editButton.setOnClickListener {
                editableComment = comment
                editTextComment.isEnabled = true
                editTextComment.setText(editableComment?.textComment)
                editablePosition = adapterPosition
                bindEditable(comment)
            }

            saveButton.setOnClickListener {
                val newComment = editTextComment.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    firebaseService.updateComment(comment.copy(textComment = newComment))
                    updateComments()
                    withContext(Dispatchers.Main) {
                        editTextComment.isEnabled = false
                        saveButton.isEnabled = false
                    }
                }
            }
        }

        fun bindEditable(comment: CommentModel) {
            saveButton.setOnClickListener {
                val newComment = editTextComment.text.toString()
                CoroutineScope(Dispatchers.IO).launch {
                    firebaseService.updateComment(comment.copy(textComment = newComment))
                    updateComments()
                }
            }
        }
    }

    private fun updateComments() {
        CoroutineScope(Dispatchers.IO).launch {
            val updatedComments = firebaseService.getComments()
            withContext(Dispatchers.Main) {
                setData(updatedComments)
                editableComment = null
                editablePosition = null
            }
        }
    }

    fun setData(comments: List<CommentModel>) {
        this.comments = comments
        notifyDataSetChanged()
    }

}
