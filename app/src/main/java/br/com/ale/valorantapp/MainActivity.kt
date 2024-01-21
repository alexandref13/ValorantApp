package br.com.ale.valorantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.ale.valorantapp.ui.screens.agentsList.AgentsListScreen
import br.com.ale.valorantapp.ui.theme.ValorantAppTheme
import br.com.ale.valorantapp.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.AGENTS_LIST
                ) {
                    composable(Routes.AGENTS_LIST) {
                        AgentsListScreen()
                    }
                }
            }
        }
    }
}