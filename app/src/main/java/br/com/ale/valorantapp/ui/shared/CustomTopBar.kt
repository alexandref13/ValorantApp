package br.com.ale.valorantapp.ui.shared

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import br.com.ale.valorantapp.R
import br.com.ale.valorantapp.ui.theme.Gray500
import br.com.ale.valorantapp.ui.theme.typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    title: String = "",
    hasIconArrowBack: Boolean = false,
    onClickIconArrowBack: () -> Boolean = {
        false
    }
) {
    TopAppBar(
        navigationIcon = {
            AnimatedVisibility(visible = hasIconArrowBack) {
                IconButton(onClick = {
                    onClickIconArrowBack()
                }) {
                    Icon(Icons.Default.ArrowBack, "Arrow back", tint = Color.Red)
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Gray500,
        ),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    title, style = typography.headlineLarge.copy(color = Color.White)
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.riot_logo),
                    tint = Color.Red,
                    contentDescription = "Riot Logo"
                )

            }
        },
    )
}