package br.com.ale.valorantapp.ui.screens.agentDetail

import br.com.ale.valorantapp.models.AgentsModel

sealed class AgentDetailsState {
    data object Loading: AgentDetailsState()
    data class Success(val agents: AgentsModel): AgentDetailsState()
    data class Error(val message: String): AgentDetailsState()
}