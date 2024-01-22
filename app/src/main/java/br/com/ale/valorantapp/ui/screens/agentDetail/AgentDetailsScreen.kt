package br.com.ale.valorantapp.ui.screens.agentDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ale.valorantapp.ui.theme.Gray300
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentDetailsScreen(
    agentDetailsViewModel: AgentDetailsViewModel = koinViewModel(),
    agentId: String?
) {
    val state by agentDetailsViewModel.state

    LaunchedEffect(Unit) {
        if (agentId != null) {
            agentDetailsViewModel.fetchAgentById(id = agentId)
        } else
            agentDetailsViewModel.fetchAgentById(id = "")

    }

    Surface(modifier = Modifier.fillMaxSize(), color = Gray300) {
        when (state) {
            is AgentDetailsState.Loading -> CircularProgressIndicator()
            is AgentDetailsState.Success -> Column {
                Text((state as AgentDetailsState.Success).agents.displayName)
            }
            is AgentDetailsState.Error -> Text("Error")
        }
    }
}


@Preview
@Composable
fun Main() {
    AgentDetailsScreen(agentId = "")
}