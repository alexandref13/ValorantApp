package br.com.ale.valorantapp.ui.screens.agentsList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.com.ale.valorantapp.ui.screens.agentsList.components.Content
import br.com.ale.valorantapp.ui.screens.agentsList.components.Header
import br.com.ale.valorantapp.ui.shared.CustomTextField
import br.com.ale.valorantapp.ui.theme.Gray300
import br.com.ale.valorantapp.utils.Routes
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentsListScreen(agentsViewModel: AgentViewModel = koinViewModel(), navController: NavHostController? = null) {
    LaunchedEffect(Unit) {
        agentsViewModel.fetchAgents()
    }

    LaunchedEffect(agentsViewModel.searchValue.value) {
        agentsViewModel.filterAgents()
    }

    val agents = agentsViewModel.filteredAgents.collectAsState().value
    val searchValue = agentsViewModel.searchValue

    Surface(modifier = Modifier.fillMaxSize(), color = Gray300) {
        Column {
            Header()
            CustomTextField(
                value = searchValue.value,
                onValueChange = { value ->
                    searchValue.value = value
                },
            )
            Content(agents, onClickItem = {
                navController!!.navigate(Routes.AGENT_DETAILS)
            })
        }
    }
}

@Preview
@Composable
fun Main() {
    AgentsListScreen()
}