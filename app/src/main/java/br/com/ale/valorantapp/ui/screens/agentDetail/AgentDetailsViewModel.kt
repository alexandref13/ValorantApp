package br.com.ale.valorantapp.ui.screens.agentDetail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.launch

class AgentDetailsViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {

    private val _state =  mutableStateOf<AgentDetailsState>(AgentDetailsState.Loading)
    val state: State<AgentDetailsState> = _state

    fun fetchAgentById(id: String) {
        viewModelScope.launch {
            try {
                val response =
                    valorantRepository.getAgentById(id)

                _state.value = AgentDetailsState.Success(
                    response
                )

            } catch (e: Exception) {
                Log.d("EXC", "FetchAgentsById: ${e.message.toString()}")
            }
        }
    }
}