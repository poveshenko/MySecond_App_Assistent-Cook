package com.example.test2.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class CommentModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val textComment: String
)
