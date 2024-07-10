package com.example.test2.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CommentDao {
    @Insert
    suspend fun addComment(comment: CommentModel)

    @Query("SELECT * FROM comments")
    suspend fun getAllComments(): List<CommentModel>

    @Delete
    suspend fun deleteComment(comment: CommentModel)

    @Update
    suspend fun updateComment(comment: CommentModel)
}
