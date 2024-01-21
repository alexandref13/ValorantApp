package br.com.ale.valorantapp.ui.screens.agentDetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.models.AgentDetailsModel
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.launch

class AgentDetailsViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {

    private val _agent =  MutableLiveData<AgentDetailsModel>()
    val agent: LiveData<AgentDetailsModel> = _agent
    fun fetchAgentById() {
        viewModelScope.launch {
            try {
                val response =
                    valorantRepository.getAgentById("e370fa57-4757-3604-3648-499e1f642d3f")

                _agent.value = response

                Log.i("AGENTE", _agent.value!!.data.displayName)
                Log.i("AGENTE", "aq")
                Log.i("AGENTE", response.data.displayName)
            } catch (e: Exception) {
                Log.d("EXC", "FetchAgents: ${e.message.toString()}")
            }
        }
    }
}