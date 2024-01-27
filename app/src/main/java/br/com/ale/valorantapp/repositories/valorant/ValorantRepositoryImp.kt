package br.com.ale.valorantapp.repositories.valorant

import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.valorant.ValorantRepository
import br.com.ale.valorantapp.services.ValorantService

class ValorantRepositoryImp(private val valorantService: ValorantService) : ValorantRepository {
    override suspend fun getAgents(): List<AgentsModel> {
       val response = valorantService.getAgents()

        if(response.body() == null || response.body()!!.data.isEmpty()){
            return emptyList()
        }

        return if(response.isSuccessful){
            response.body()!!.data
        }else {
            emptyList()
        }
    }

    override suspend fun getAgentById(id: String): AgentsModel {
        val response =  valorantService.getAgentById(id)

        return response.body()!!.data
    }
}