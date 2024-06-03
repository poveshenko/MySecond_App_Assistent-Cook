package com.example.test2.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.test2.dataBase.CommentModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {


    @Query("SELECT * FROM comments")
    suspend fun getAllComments(): List<CommentModel>
    @Insert
    suspend fun insertComment(commentModel: CommentModel)

    @Delete
    suspend fun deleteComment(commentModel: CommentModel)

    @Update
    suspend fun updateComment(commentModel: CommentModel)

}