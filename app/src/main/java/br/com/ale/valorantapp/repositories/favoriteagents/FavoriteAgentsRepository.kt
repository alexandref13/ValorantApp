package br.com.ale.valorantapp.repositories.favoriteagents

import br.com.ale.valorantapp.db.FavoriteAgentEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteAgentsRepository {
    suspend fun addFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity)
    suspend fun deleteFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity)
    fun getAllFavoriteAgents(): Flow<List<FavoriteAgentEntity>>
}