package br.com.ale.valorantapp.ui.screens.favoritesagents

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.db.FavoriteAgentEntity
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.favoriteagents.FavoriteAgentsRepository
import kotlinx.coroutines.launch

class FavoriteAgentsViewModel(private val favoriteAgentsRepository: FavoriteAgentsRepository) :
    ViewModel() {

    val favoriteAgents = favoriteAgentsRepository.getAllFavoriteAgents()

    fun addFavoriteAgent(agentsModel: AgentsModel) {
        viewModelScope.launch {
            val favoriteAgentEntity = FavoriteAgentEntity(
                agentId = agentsModel.uuid,
                name = agentsModel.displayName,
                icon = agentsModel.displayIcon,
                roleIcon = agentsModel.role
                    .displayIcon,
                roleName = agentsModel.role
                    .displayName
            )
            favoriteAgentsRepository.addFavoriteAgent(favoriteAgentEntity)
        }
    }

    fun deleteFavoriteAgent(favoriteAgentEntity: FavoriteAgentEntity) {
        viewModelScope.launch {
            favoriteAgentsRepository.deleteFavoriteAgent(favoriteAgentEntity)
        }
    }
}