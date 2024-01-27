package br.com.ale.valorantapp.ui.screens.agentsList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.ale.composefirstapp.utils.UiEvent
import br.com.ale.valorantapp.ui.screens.agentsList.components.Content
import br.com.ale.valorantapp.ui.shared.CustomTextField
import br.com.ale.valorantapp.ui.shared.CustomTopBar
import br.com.ale.valorantapp.ui.theme.Gray300
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentsListScreen(
    agentsViewModel: AgentViewModel = koinViewModel(), onNavigate: (UiEvent.Navigate) -> Unit
) {
    val state = agentsViewModel.state
    val searchValue = agentsViewModel.searchValue

    LaunchedEffect(Unit) {
        agentsViewModel.fetchAgents()
    }

    LaunchedEffect(agentsViewModel.searchValue.value) {
        if (searchValue.value.text.isNotEmpty()) {
            agentsViewModel.filterAgents()
        }
    }



    Scaffold(topBar = {
        CustomTopBar(title = "Valorant")
    }, containerColor = Gray300) { innerPadding ->
        when (state.value) {
            is AgentsViewState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is AgentsViewState.Success -> {
                Column(modifier = Modifier.padding(innerPadding)) {
                    CustomTextField(
                        value = searchValue.value,
                        onValueChange = { value ->
                            searchValue.value = value
                        },
                    )
                    Content((state.value as AgentsViewState.Success).agents, onNavigate)
                }

            }

            is AgentsViewState.Error -> Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text("Algo deu errado, reinicie o APP")
            }

        }
    }
}


@Preview
@Composable
fun Main() {
    AgentsListScreen(onNavigate = {})
}