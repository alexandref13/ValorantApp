package br.com.ale.valorantapp.utils

import androidx.compose.ui.graphics.Color
import br.com.ale.valorantapp.db.FavoriteAgentEntity
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.ui.screens.favoritesagents.FavoriteAgentsViewModel

fun isAgentFavorite(favoriteAgents: List<FavoriteAgentEntity>, agent: AgentsModel): Boolean {
    var agentIsFavorite = false
    favoriteAgents.forEach {
        if (it.agentId == agent.uuid) {
            agentIsFavorite = true
        }
    }

    return agentIsFavorite
}


fun favoriteOrUnfavoriteAgent(
    favoriteAgents: List<FavoriteAgentEntity>,
    agent: AgentsModel,
    favoriteAgentsViewModel: FavoriteAgentsViewModel
) {
    val isAgentFavorite = isAgentFavorite(favoriteAgents, agent)

    if (isAgentFavorite) {
        val filteredFavoriteAgents =
            favoriteAgents.filter { favoriteAgent ->
                favoriteAgent.agentId == agent.uuid
            }

        favoriteAgentsViewModel.deleteFavoriteAgent(filteredFavoriteAgents.first())

    } else {
        favoriteAgentsViewModel.addFavoriteAgent(agent)
    }
}

fun iconStarColor(favoriteAgents: List<FavoriteAgentEntity>, agent: AgentsModel): Color {
    return if (isAgentFavorite(favoriteAgents, agent)) {
        Color.Yellow
    } else {
        Color.Black
    }
}