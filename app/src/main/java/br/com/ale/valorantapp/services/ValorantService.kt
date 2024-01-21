package br.com.ale.valorantapp.services

import br.com.ale.valorantapp.models.ValorantModel
import retrofit2.http.GET

interface ValorantService {
    @GET("agents")
    suspend fun getAgents(): ValorantModel
}
