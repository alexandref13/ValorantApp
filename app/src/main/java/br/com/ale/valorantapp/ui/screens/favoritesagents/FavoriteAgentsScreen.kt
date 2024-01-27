package br.com.ale.valorantapp.ui.screens.favoritesagents

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.ale.valorantapp.ui.shared.CustomTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteAgentsScreen(
    favoriteAgentsViewModel: FavoriteAgentsViewModel = koinViewModel(),
    navigateController: NavHostController
) {
    val favoriteAgents =
        favoriteAgentsViewModel.favoriteAgents.collectAsState(initial = emptyList())

    Log.i("FAVORITE_AGENT ", favoriteAgents.value.size.toString())
    Scaffold(topBar = {
        CustomTopBar(title = "FavoriteScreen", hasIconArrowBack = true, onClickIconArrowBack = {
            navigateController.popBackStack()
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favoriteAgents.value) { favorite ->
                    Box(
                        modifier = Modifier
                            .background(Color.Black)
                            .padding(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(favorite.name, color = Color.White)
                                Text(favorite.roleName, color = Color.White)
                            }

                            IconButton(onClick = {
                                favoriteAgentsViewModel.deleteFavoriteAgent(favorite)
                            }) {
                                Icon(Icons.Outlined.Delete, "Delete Icon", tint = Color.White)
                            }
                        }
                    }

                }
            }
        }
    }
}