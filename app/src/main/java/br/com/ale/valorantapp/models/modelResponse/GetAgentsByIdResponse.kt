package br.com.ale.valorantapp.models.modelResponse

import br.com.ale.valorantapp.models.AgentsModel

data class GetAgentsByIdResponse(
    val data: AgentsModel,
    val status: Int
)