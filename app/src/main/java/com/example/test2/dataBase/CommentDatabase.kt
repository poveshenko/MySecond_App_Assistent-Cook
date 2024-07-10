package com.example.test2.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CommentModel::class], version = 1, exportSchema = false)
abstract class CommentDatabase : RoomDatabase() {
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile
        private var INSTANCE: CommentDatabase? = null

        fun getDatabase(context: Context): CommentDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CommentDatabase::class.java,
                    "comment_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
