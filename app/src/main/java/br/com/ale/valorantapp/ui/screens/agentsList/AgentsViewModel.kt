package br.com.ale.valorantapp.ui.screens.agentsList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AgentViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {
    private val _agents = MutableStateFlow(emptyList<AgentsModel>())
    val agent: StateFlow<List<AgentsModel>> = _agents.asStateFlow()

    fun fetchAgents() {
        viewModelScope.launch {
            try {
                val response = valorantRepository.getAgents()
                _agents.value = response.data
            } catch (e: Exception) {
                Log.d("EXC", "FetchAgents: ${e.message.toString()}")
            }
        }
    }
}