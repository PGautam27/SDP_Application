package com.example.publicproblemtrackingapp.view.user.loginAndSignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.example.publicproblemtrackingapp.view.user.components.NavBackIcon

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(
        topBar = {
            NavBackIcon(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "")
        }
    }
}