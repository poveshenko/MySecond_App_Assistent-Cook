package com.example.test2.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CommentModel::class], version = 1)
abstract class CommentDatabase : RoomDatabase() {
    abstract fun getDao(): CommentDao

    companion object {
        fun getCommentDatabase(context: Context): CommentDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                CommentDatabase::class.java,
                name = "test.db"
            ).build()
        }
    }
}
