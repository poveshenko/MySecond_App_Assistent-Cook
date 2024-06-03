package com.example.test2.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.test2.dataBase.CommentModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {


    @Query("SELECT * FROM comments")
    suspend fun getAllComments(): List<CommentModel>
    @Insert
    suspend fun insertComment(commentModel: CommentModel)


}