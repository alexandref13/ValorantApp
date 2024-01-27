package br.com.ale.valorantapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteAgentsDao {
    @Upsert()
    suspend fun addFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity)

    @Query("SELECT * FROM favorite_agents")
    fun getAllFavoriteAgents(): Flow<List<FavoriteAgentEntity>>

    @Delete()
    suspend fun deleteFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity)
}