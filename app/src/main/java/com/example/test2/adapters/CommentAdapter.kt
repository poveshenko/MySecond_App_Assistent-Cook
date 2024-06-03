package com.example.test2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.test2.dataBase.CommentModel
import com.example.test2.R
import com.example.test2.dataBase.CommentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


    class CommentAdapter(private var comments: List<CommentModel>, private val commentDatabase: CommentDatabase) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
        private var editableComment: CommentModel? = null
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

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: CommentModel) {
            itemView.findViewById<TextView>(R.id.textNameComment).text = comment.name
            itemView.findViewById<TextView>(R.id.textComment).text = comment.textComment
            val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)
            val editButton: ImageButton = itemView.findViewById(R.id.editButton)

            // Обработчик нажатия на кнопку удаления
            deleteButton.setOnClickListener {
                GlobalScope.launch(Dispatchers.IO) {
                    // Удаление комментария из базы данных
                    commentDatabase.getDao().deleteComment(comment)

                    // Получение обновленного списка комментариев
                    val updatedComments = commentDatabase.getDao().getAllComments()

                    withContext(Dispatchers.Main) {
                        // Обновление списка комментариев в RecyclerView
                        setData(updatedComments)
                    }
                }
            }

            // Обработчик нажатия на кнопку редактирования
            editButton.setOnClickListener {
                editableComment = comment
                // Заполните поля для редактирования значениями из editableComment
                itemView.findViewById<TextView>(R.id.editTextName).text = editableComment?.name
                itemView.findViewById<TextView>(R.id.editTextComment).text = editableComment?.textComment
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(comments: List<CommentModel>) {
        this.comments = comments
        notifyDataSetChanged()
    }
}