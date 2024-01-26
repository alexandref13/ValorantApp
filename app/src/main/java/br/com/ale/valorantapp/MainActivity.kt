package br.com.ale.valorantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        navController = navController, startDestination = Routes.AGENTS_LIST
    ) {
        composable(Routes.AGENTS_LIST) {
            AgentsListScreen(onNavigate = {
                navController.navigate(it.route)
            })
        }
        composable(
            Routes.AGENT_DETAILS + "/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            AgentDetailsScreen(
                agentId = it.arguments?.getString("id"),
                navigateController = navController
            )
        }
    }
}