package br.com.ale.valorantapp.ui.screens.agentsList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.ale.valorantapp.ui.theme.Gray700
import br.com.ale.valorantapp.ui.theme.typography

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Gray700, shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            )
            .padding(32.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Valorant - Agents",
            style = typography.headlineLarge.copy(color = Color.White)
        )
    }
}

