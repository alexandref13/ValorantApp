package br.com.ale.valorantapp.ui.screens.agentsList

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.repositories.ValorantRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Locale

class AgentViewModel(private val valorantRepository: ValorantRepository) : ViewModel() {
    private val _agents = mutableStateOf(emptyList<AgentsModel>())

    private val _state = mutableStateOf<AgentsViewState>(AgentsViewState.Loading)
    val state: State<AgentsViewState> = _state

    private var _searchValue = mutableStateOf(TextFieldValue(""))
    val searchValue: MutableState<TextFieldValue> = _searchValue


    fun fetchAgents() {
        viewModelScope.launch {
            _state.value = AgentsViewState.Loading
            try {
                delay(2000)
                val response = valorantRepository.getAgents()

                Log.i("RESPONSE_GET_AGENTS", "AQ")

                _agents.value = response
                _state.value = AgentsViewState.Success(response)
            } catch (e: Exception) {
                Log.d("EXC", "FetchAgents: ${e.message.toString()}")
            }
        }
    }

    fun filterAgents() {
        _state.value = AgentsViewState.Loading

        if (searchValue.value.text.trim().isEmpty()) {
            _state.value = AgentsViewState.Success(_agents.value)

            return
        }

        val filter =
            _agents.value.filter { agent ->
                searchValue.value.text in agent.displayName.lowercase(
                    Locale.ROOT
                )
            }
        _state.value = AgentsViewState.Success(filter)
    }
}