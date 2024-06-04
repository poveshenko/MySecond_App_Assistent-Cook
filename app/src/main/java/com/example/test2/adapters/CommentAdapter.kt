package com.example.test2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test2.R
import com.example.test2.dataBase.CommentDatabase
import com.example.test2.dataBase.CommentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommentAdapter(
    private var comments: List<CommentModel>,
    private val commentDatabase: CommentDatabase
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
                GlobalScope.launch(Dispatchers.IO) {
                    commentDatabase.getDao().deleteComment(comment)
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
                GlobalScope.launch(Dispatchers.IO) {
                    commentDatabase.getDao().updateComment(comment.copy(textComment = newComment))
                    updateComments()
                    editTextComment.isEnabled = false
                    saveButton.isEnabled = false
                }
            }
        }

        fun bindEditable(comment: CommentModel) {
            saveButton.setOnClickListener {
                val newComment = editTextComment.text.toString()
                GlobalScope.launch(Dispatchers.IO) {
                    commentDatabase.getDao().updateComment(comment.copy(textComment = newComment))
                    updateComments()
                }
            }
        }
    }

    private fun updateComments() {
        GlobalScope.launch(Dispatchers.IO) {
            val updatedComments = commentDatabase.getDao().getAllComments()
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