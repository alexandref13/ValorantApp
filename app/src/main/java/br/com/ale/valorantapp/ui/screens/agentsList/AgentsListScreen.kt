package br.com.ale.valorantapp.ui.screens.agentsList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ale.valorantapp.ui.screens.agentsList.components.Content
import br.com.ale.valorantapp.ui.screens.agentsList.components.Header
import br.com.ale.valorantapp.ui.theme.Gray300

@Composable
fun AgentsListScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = Gray300) {
        Column {
            Header()
            Content()
        }
    }
}

@Preview
@Composable
fun Main() {
    AgentsListScreen()
}