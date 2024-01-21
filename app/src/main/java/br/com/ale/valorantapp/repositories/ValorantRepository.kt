package br.com.ale.valorantapp.repositories

import br.com.ale.valorantapp.models.AgentDetailsModel
import br.com.ale.valorantapp.models.ValorantModel

interface ValorantRepository {
    suspend fun getAgents(): ValorantModel
    suspend fun getAgentById(id: String): AgentDetailsModel
}