package br.com.ale.valorantapp.ui.screens.agentDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ale.valorantapp.ui.theme.Gray300
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentDetailsScreen(agentDetailsViewModel: AgentDetailsViewModel = koinViewModel()) {
    val agent by agentDetailsViewModel.agent.observeAsState(null)

    LaunchedEffect(Unit) {
        agentDetailsViewModel.fetchAgentById()
    }

    Surface(modifier = Modifier.fillMaxSize(), color = Gray300) {
        Column {
            if(agent == null){
                return@Column Text("Teste")
            } else {
                return@Column  Text(agent!!.data.displayName)
            }
        }
    }
}

@Preview
@Composable
fun Main() {
    AgentDetailsScreen()
}