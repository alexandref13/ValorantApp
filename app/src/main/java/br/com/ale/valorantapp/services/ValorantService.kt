package br.com.ale.valorantapp.services

import br.com.ale.valorantapp.models.AgentDetailsModel
import br.com.ale.valorantapp.models.ValorantModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantService {
    @GET("agents")
    suspend fun getAgents(): ValorantModel

    @GET("agents/{id}")
    suspend fun getAgentById(@Path("id") id: String): AgentDetailsModel
}

