package com.example.publicproblemtrackingapp.presentation.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.example.publicproblemtrackingapp.presentation.screens.Screen
import com.example.publicproblemtrackingapp.presentation.user.components.NavBackIcon

@Composable
fun UserScreen(navController: NavController) {
    Scaffold(
        topBar = {
            NavBackIcon(navController = navController)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Yellow)
                .fillMaxSize()
        ) {
            Text(text = "Already Have an Account", style = TextStyle( fontSize = LocalConfiguration.current.fontScale.times(25).sp,fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { navController.navigate(Screen.UserLoginScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier
                    .height(LocalConfiguration.current.screenHeightDp.dp / 10)
                    .width(
                        LocalConfiguration.current.screenWidthDp.dp - 40.dp
                    )
            ) {
                Text(text = "SIGN IN", style = TextStyle(fontWeight = FontWeight.Bold))
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Divider(color = Orange, thickness = 2.dp, modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp -80.dp))
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Don't have One?",style = TextStyle( fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { navController.navigate(Screen.UserSignUpScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier
                    .height(LocalConfiguration.current.screenHeightDp.dp / 10)
                    .width(
                        LocalConfiguration.current.screenWidthDp.dp - 40.dp
                    )
            ) {
                Text(text = "SIGN UP", style = TextStyle(fontWeight = FontWeight.Bold))
            }
        }
    }

}