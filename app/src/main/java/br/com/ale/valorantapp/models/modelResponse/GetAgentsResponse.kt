package br.com.ale.valorantapp.models.modelResponse

import br.com.ale.valorantapp.models.AgentsModel

data class GetAgentsResponse(
    val data: List<AgentsModel>,
    val status: Int
)