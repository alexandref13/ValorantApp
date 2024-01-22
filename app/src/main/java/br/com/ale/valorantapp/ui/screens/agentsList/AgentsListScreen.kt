package br.com.ale.valorantapp.ui.screens.agentsList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.ale.composefirstapp.utils.UiEvent
import br.com.ale.valorantapp.R
import br.com.ale.valorantapp.ui.screens.agentsList.components.Content
import br.com.ale.valorantapp.ui.shared.CustomTextField
import br.com.ale.valorantapp.ui.theme.Gray300
import br.com.ale.valorantapp.ui.theme.Gray500
import br.com.ale.valorantapp.ui.theme.typography
import br.com.ale.valorantapp.utils.Routes
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentsListScreen(
    agentsViewModel: AgentViewModel = koinViewModel(), onNavigate: (UiEvent.Navigate) -> Unit
) {
    LaunchedEffect(Unit) {
        agentsViewModel.fetchAgents()
    }

    LaunchedEffect(agentsViewModel.searchValue.value) {
        agentsViewModel.filterAgents()
    }

    val agents = agentsViewModel.filteredAgents.collectAsState().value
    val searchValue = agentsViewModel.searchValue

    Scaffold(topBar = {
        TopAppBar(
            colors = topAppBarColors(
                containerColor = Gray500,
            ),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        "Valorant", style = typography.headlineLarge.copy(color = Color.White)
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.riot_logo),
                        tint = Color.Red,
                        contentDescription = "Riot Logo"
                    )

                }
            },
        )
    }, containerColor = Gray300) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (agents.isEmpty() && searchValue.value.text.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                CustomTextField(
                    value = searchValue.value,
                    onValueChange = { value ->
                        searchValue.value = value
                    },
                )
                Content(agents, onClickItem = {
                    onNavigate(UiEvent.Navigate(Routes.AGENT_DETAILS))
                })
            }
        }
    }
}

@Preview
@Composable
fun Main() {
    AgentsListScreen(onNavigate = {})
}