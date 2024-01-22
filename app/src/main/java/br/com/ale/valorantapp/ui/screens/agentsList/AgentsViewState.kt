package br.com.ale.valorantapp.ui.screens.agentsList

import br.com.ale.valorantapp.models.AgentsModel

sealed class AgentsViewState {
    data object Loading: AgentsViewState()
    data class Success(val agents: List<AgentsModel>): AgentsViewState()
    data class Error(val message: String): AgentsViewState()
}