package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.ale.composefirstapp.utils.UiEvent
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.ui.screens.favoritesagents.FavoriteAgentsViewModel
import br.com.ale.valorantapp.ui.theme.BlueDark
import br.com.ale.valorantapp.ui.theme.typography
import br.com.ale.valorantapp.utils.Routes
import br.com.ale.valorantapp.utils.favoriteOrUnfavoriteAgent
import br.com.ale.valorantapp.utils.iconStarColor
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun AgentItem(
    agent: AgentsModel,
    onClickItem: (UiEvent.Navigate) -> Unit,
    favoriteAgentsViewModel: FavoriteAgentsViewModel = koinViewModel()
) {

    val favoriteAgents =
        favoriteAgentsViewModel.favoriteAgents.collectAsState(initial = emptyList())

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 16.dp)
        .background(
            BlueDark, shape = RoundedCornerShape(
                topEnd = 8.dp, topStart = 8.dp, bottomEnd = 8.dp, bottomStart = 8.dp
            )
        )
        .clickable {
            onClickItem(UiEvent.Navigate("${Routes.AGENT_DETAILS}/${agent.uuid}"))
        }) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = agent.displayIcon,
                contentDescription = "Agent Image",
                modifier = Modifier.size(52.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.padding(bottom = 8.dp), verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row {
                        Text(
                            agent.displayName,
                            style = typography.bodyLarge.copy(color = Color.White)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
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
                Text(
                    agent.description,
                    textAlign = TextAlign.Justify,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = typography.bodySmall.copy(color = Color.White)
                )

            }
        }
    }
}