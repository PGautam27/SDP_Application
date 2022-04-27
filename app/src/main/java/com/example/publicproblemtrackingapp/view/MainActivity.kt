package com.example.publicproblemtrackingapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.publicproblemtrackingapp.ui.theme.PublicProblemTrackingAppTheme
import com.example.publicproblemtrackingapp.view.HomeScreen.HomeScreen
import com.example.publicproblemtrackingapp.view.screens.Screen
import com.example.publicproblemtrackingapp.view.user.UserScreen
import com.example.publicproblemtrackingapp.view.user.loginAndSignUp.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PublicProblemTrackingAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.HomeScreen.route){
                    composable(
                        Screen.HomeScreen.route
                    ){
                        HomeScreen(navController)
                    }
                    composable(
                        Screen.UserScreen.route
                    ){
                        UserScreen(navController = navController)
                    }
                    composable(
                        Screen.UserLoginScreen.route
                    ){
                        LoginScreen(navController = navController)
                    }
                    composable(Screen.UserHomeScreen.route){

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PublicProblemTrackingAppTheme {
        Greeting("Android")
    }
}