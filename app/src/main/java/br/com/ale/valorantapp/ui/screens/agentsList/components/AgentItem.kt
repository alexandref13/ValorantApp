package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import br.com.ale.valorantapp.models.AgentsModel
import br.com.ale.valorantapp.ui.theme.BlueDark
import br.com.ale.valorantapp.ui.theme.typography
import coil.compose.AsyncImage

@Composable
fun AgentItem(agent: AgentsModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .background(
                BlueDark,
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                    topStart = 8.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 8.dp
                )
            )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = agent.displayIcon,
                contentDescription = "Agent Image",
                modifier = Modifier.size(52.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(agent.displayName, style = typography.bodyLarge.copy(color = Color.White))
                Spacer(modifier = Modifier.height(4.dp))
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