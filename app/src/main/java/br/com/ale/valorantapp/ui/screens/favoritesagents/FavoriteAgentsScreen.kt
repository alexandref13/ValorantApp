package br.com.ale.valorantapp.ui.screens.favoritesagents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.ale.composefirstapp.utils.UiEvent
import br.com.ale.valorantapp.ui.screens.favoritesagents.components.FavoriteAgentItem
import br.com.ale.valorantapp.ui.shared.CustomTopBar
import br.com.ale.valorantapp.ui.theme.Gray300
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteAgentsScreen(
    favoriteAgentsViewModel: FavoriteAgentsViewModel = koinViewModel(),
    navigateController: NavHostController,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val favoriteAgents =
        favoriteAgentsViewModel.favoriteAgents.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            CustomTopBar(title = "Favorite Agents", hasIconArrowBack = true, onClickIconArrowBack = {
                navigateController.popBackStack()
            })
        },
        containerColor = Gray300
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favoriteAgents.value.sortedBy { agent ->
                    agent.name
                }) { favorite ->
                    FavoriteAgentItem(favoriteAgent = favorite, onClickItem = onNavigate)
                }
            }
        }
    }
}