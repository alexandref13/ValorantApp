package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import br.com.ale.valorantapp.models.AgentsModel

@Composable
fun Content(agents: List<AgentsModel>) {
    if (agents.isEmpty()) return CircularProgressIndicator() else
        LazyColumn {
            items(agents) { agent ->
                AgentItem(agent)
            }
        }
}