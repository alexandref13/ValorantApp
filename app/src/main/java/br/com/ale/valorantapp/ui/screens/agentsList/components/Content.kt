package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.ale.valorantapp.models.AgentsModel

@Composable
fun Content(agents: List<AgentsModel>, onClickItem: () -> Unit) {
    LazyColumn {
        items(agents) { agent ->
            AgentItem(agent, onClickItem)
        }
    }
}