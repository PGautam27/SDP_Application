package com.example.publicproblemtrackingapp.view.user.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Yellow

@Composable
fun NavBackIcon(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "")
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Filled.ArrowBack, "backIcon", modifier = Modifier.width(
                    LocalConfiguration.current.screenWidthDp.dp/15).height(
                    LocalConfiguration.current.screenHeightDp.dp/15))
            }
        },
        backgroundColor = Yellow,
        contentColor = Color.Black,
        elevation = AppBarDefaults.TopAppBarElevation.times(0)
    )

}