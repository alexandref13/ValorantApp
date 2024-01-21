package br.com.ale.valorantapp.repositories

import br.com.ale.valorantapp.models.AgentDetailsModel
import br.com.ale.valorantapp.models.ValorantModel
import br.com.ale.valorantapp.services.ValorantService

class ValorantRepositoryImp(private val valorantService: ValorantService) : ValorantRepository {
    override suspend fun getAgents(): ValorantModel {
        return valorantService.getAgents()
    }

    override suspend fun getAgentById(id: String): AgentDetailsModel {
        return valorantService.getAgentById(id)
    }
}