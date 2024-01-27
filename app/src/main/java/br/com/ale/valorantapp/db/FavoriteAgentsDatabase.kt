package br.com.ale.valorantapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteAgentEntity::class], version = 1)
abstract class FavoriteAgentsDatabase : RoomDatabase() {
    abstract fun favoriteAgentDao(): FavoriteAgentsDao
}

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, FavoriteAgentsDatabase::class.java, "favorit_agent_db")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: FavoriteAgentsDatabase) = db.favoriteAgentDao()