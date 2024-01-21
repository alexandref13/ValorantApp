package br.com.ale.valorantapp.services

import br.com.ale.valorantapp.models.modelResponse.GetAgentsByIdResponse
import br.com.ale.valorantapp.models.modelResponse.GetAgentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ValorantService {
    @GET("agents")
    suspend fun getAgents(): Response<GetAgentsResponse>

    @GET("agents/{id}")
    suspend fun getAgentById(@Path("id") id: String): Response<GetAgentsByIdResponse>
}

