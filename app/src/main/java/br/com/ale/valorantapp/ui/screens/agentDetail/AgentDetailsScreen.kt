package br.com.ale.valorantapp.ui.screens.agentDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.ale.valorantapp.ui.screens.agentDetail.components.AgentDetailComponent
import br.com.ale.valorantapp.ui.shared.CustomTopBar
import br.com.ale.valorantapp.ui.theme.Gray300
import br.com.ale.valorantapp.ui.theme.typography
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentDetailsScreen(
    agentDetailsViewModel: AgentDetailsViewModel = koinViewModel(),
    agentId: String?,
    navigateController: NavHostController
) {
    val state = agentDetailsViewModel.state

    LaunchedEffect(Unit) {
        if (agentId != null) {
            agentDetailsViewModel.fetchAgentById(id = agentId)
        } else
            agentDetailsViewModel.fetchAgentById(id = "")
    }



    Scaffold(topBar = {
        CustomTopBar(title = "Details", hasIconArrowBack = true, onClickIconArrowBack = {
            navigateController.popBackStack()
        })
    }, containerColor = Gray300) { innerPadding ->
        when (state.value) {
            is AgentDetailsState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is AgentDetailsState.Success -> {
                Column(modifier = Modifier.padding(innerPadding)) {
                    Spacer(modifier = Modifier.height(16.dp))
                    AgentDetailComponent((state.value as AgentDetailsState.Success).agents,)
                    Spacer(modifier = Modifier.height(32.dp))

                    Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Column {
                            Text(
                                "Abilities",
                                style = typography.headlineLarge.copy(color = Color.White)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                "Comming soon...",
                                style = typography.bodySmall.copy(color = Color.White)
                            )
                        }
                    }
                }

            }

            is AgentDetailsState.Error -> Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text("Algo deu errado, reinicie o APP")
            }
        }
    }
}