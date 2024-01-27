package br.com.ale.valorantapp.repositories.favoriteagents

import br.com.ale.valorantapp.db.FavoriteAgentEntity
import br.com.ale.valorantapp.db.FavoriteAgentsDao
import kotlinx.coroutines.flow.Flow

class FavoriteAgentsRepositoryImp(private val favoriteAgentsDao: FavoriteAgentsDao) :
    FavoriteAgentsRepository {
    override suspend fun addFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity) {
        favoriteAgentsDao.addFavoriteAgent(favoriteAgentEntity)
    }

    override suspend fun deleteFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity) {
        favoriteAgentsDao.deleteFavoriteAgent(favoriteAgentEntity)
    }

    override fun getAllFavoriteAgents(): Flow<List<FavoriteAgentEntity>> {
        return favoriteAgentsDao.getAllFavoriteAgents()
    }

}