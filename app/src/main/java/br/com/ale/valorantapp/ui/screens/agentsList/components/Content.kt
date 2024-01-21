package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun Content() {
    LazyColumn {
        items(5) {
            AgentItem()
        }
    }
}