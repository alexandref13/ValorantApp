package br.com.ale.valorantapp.ui.screens.agentsList

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class AgentViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {
    private val _agents = MutableStateFlow(emptyList<AgentsModel>())

    private val _filteredAgents = MutableStateFlow(emptyList<AgentsModel>())
    val filteredAgents: StateFlow<List<AgentsModel>> = _filteredAgents.asStateFlow()

    private var _searchValue = mutableStateOf(TextFieldValue(""))
    val searchValue: MutableState<TextFieldValue> = _searchValue

    fun fetchAgents() {
        viewModelScope.launch {
            try {
                val response = valorantRepository.getAgents()
                _agents.value = response.data
                _filteredAgents.value = response.data
            } catch (e: Exception) {
                Log.d("EXC", "FetchAgents: ${e.message.toString()}")
            }
        }
    }

    fun filterAgents() {
        if (searchValue.value.text.trim().isEmpty()) {
            _filteredAgents.value = _agents.value

            return
        }

        val filter =
            _agents.value.filter { agent ->
                searchValue.value.text in agent.displayName.lowercase(
                    Locale.ROOT
                )
            }
        _filteredAgents.value = filter
    }
}