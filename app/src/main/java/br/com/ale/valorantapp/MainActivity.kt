package br.com.ale.valorantapp

import BottomNavItem
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.ale.valorantapp.ui.screens.agentDetail.AgentDetailsScreen
import br.com.ale.valorantapp.ui.screens.agentsList.AgentsListScreen
import br.com.ale.valorantapp.ui.screens.favoritesagents.FavoriteAgentsScreen
import br.com.ale.valorantapp.ui.theme.BlueDark
import br.com.ale.valorantapp.ui.theme.Gray300
import br.com.ale.valorantapp.ui.theme.ValorantAppTheme
import br.com.ale.valorantapp.ui.theme.typography
import br.com.ale.valorantapp.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantAppTheme {
                MainScreenView()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", icon = Icons.Default.Home, Routes.AGENTS_LIST),
        BottomNavItem("Favorite", icon = Icons.Default.Star, Routes.FAVORITE_AGENTS),
    )
    BottomNavigation(
        backgroundColor = BlueDark,
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination

        items.forEach { item ->
            val isSelected = currentRoute?.route == item.screenRoute

            BottomNavigationItem(
                selected = isSelected,
                unselectedContentColor = Gray300,
                selectedContentColor = Color.White,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = "Bottom Navigator Icon",
                        tint = if (isSelected) Color.White else Color.Black
                    )
                },
                label = { Text(item.title, style = typography.bodySmall) }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Routes.AGENTS_LIST
    ) {
        composable(Routes.AGENTS_LIST) {
            AgentsListScreen(onNavigate = {
                navController.navigate(it.route)
            })
        }

        composable(
            Routes.FAVORITE_AGENTS,
        ) {
            FavoriteAgentsScreen(navigateController = navController)
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