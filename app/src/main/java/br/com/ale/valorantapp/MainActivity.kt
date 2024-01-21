package br.com.ale.valorantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ale.valorantapp.ui.screens.agentDetail.AgentDetailsScreen
import br.com.ale.valorantapp.ui.screens.agentsList.AgentsListScreen
import br.com.ale.valorantapp.ui.theme.ValorantAppTheme
import br.com.ale.valorantapp.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Routes.AGENT_DETAILS
    ) {
        composable(Routes.AGENTS_LIST, ) {
            AgentsListScreen(navController = navController)
        }
        composable(Routes.AGENT_DETAILS) {
            AgentDetailsScreen()
        }
    }
}