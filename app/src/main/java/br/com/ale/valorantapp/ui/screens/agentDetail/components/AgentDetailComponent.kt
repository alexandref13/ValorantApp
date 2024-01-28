package br.com.ale.valorantapp.ui.screens.agentDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.ui.screens.favoritesagents.FavoriteAgentsViewModel
import br.com.ale.valorantapp.ui.theme.typography
import br.com.ale.valorantapp.utils.favoriteOrUnfavoriteAgent
import br.com.ale.valorantapp.utils.iconStarColor
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentDetailComponent(
    agent: AgentsModel,
    favoriteAgentsViewModel: FavoriteAgentsViewModel = koinViewModel()
) {
    val favoriteAgents =
        favoriteAgentsViewModel.favoriteAgents.collectAsState(initial = emptyList())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        AsyncImage(
            model = agent.displayIcon,
            contentDescription = "Agent Image",
            modifier = Modifier.size(52.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Role: ${agent.role.displayName}",
                        style = typography.headlineLarge.copy(color = Color.White)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AsyncImage(
                        model = agent.role.displayIcon,
                        contentDescription = "Agent Image",
                        modifier = Modifier.size(20.dp)
                    )
                }
                IconButton(onClick = {
                    favoriteOrUnfavoriteAgent(
                        favoriteAgents = favoriteAgents.value,
                        agent = agent,
                        favoriteAgentsViewModel = favoriteAgentsViewModel
                    )
                }) {
                    Icon(
                        Icons.Default.Star,
                        "Star Icon",
                        tint = iconStarColor(
                            favoriteAgents = favoriteAgents.value,
                            agent = agent
                        ),
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                agent.description,
                textAlign = TextAlign.Justify,
                style = typography.headlineSmall.copy(color = Color.White)
            )
        }
    }
}
