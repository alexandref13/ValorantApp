package br.com.ale.valorantapp.ui.screens.agentDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.launch

class AgentDetailsViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {

    private val _agent =  MutableLiveData<AgentsModel>()
    val agent: LiveData<AgentsModel> = _agent
    fun fetchAgentById() {
        viewModelScope.launch {
            try {
                val response =
                    valorantRepository.getAgentById("e370fa57-4757-3604-3648-499e1f642d3f")

                _agent.value = response

            } catch (e: Exception) {
                Log.d("EXC", "FetchAgentsById: ${e.message.toString()}")
            }
        }
    }
}