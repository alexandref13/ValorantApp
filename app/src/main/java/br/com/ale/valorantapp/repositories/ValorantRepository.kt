package br.com.ale.valorantapp.repositories

import br.com.ale.valorantapp.models.AgentsModel

interface ValorantRepository {
    suspend fun getAgents(): List<AgentsModel>
    suspend fun getAgentById(id: String): AgentsModel
}