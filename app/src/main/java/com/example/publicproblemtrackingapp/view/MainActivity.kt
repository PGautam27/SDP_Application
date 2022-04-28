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
import com.example.publicproblemtrackingapp.view.admin.AdminHomeScreen
import com.example.publicproblemtrackingapp.view.admin.AdminLoginScreen
import com.example.publicproblemtrackingapp.view.admin.AdminScreen
import com.example.publicproblemtrackingapp.view.screens.Screen
import com.example.publicproblemtrackingapp.view.user.UserScreen
import com.example.publicproblemtrackingapp.view.user.loginAndSignUp.LoginScreen
import com.example.publicproblemtrackingapp.view.user.loginAndSignUp.UserHomeScreen
import com.example.publicproblemtrackingapp.view.user.loginAndSignUp.UserOtpScreen
import com.example.publicproblemtrackingapp.view.user.loginAndSignUp.UserSignUpScreen

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
                        LoginScreen(navController = navController, context = this@MainActivity)
                    }
                    composable(Screen.UserHomeScreen.route){
                        UserHomeScreen(navController = navController)
                    }
                    composable(
                        Screen.UserOtpScreen.route
                    ){
                        UserOtpScreen(navController = navController)
                    }
                    composable(
                        Screen.AdminScreen.route
                    ){
                        AdminScreen(navController = navController)
                    }
                    composable(
                        Screen.AdminLoginScreen.route
                    ){
                        AdminLoginScreen(navController = navController, context = this@MainActivity)
                    }
                    composable(
                        Screen.AdminHomeScreen.route
                    ){
                        AdminHomeScreen(navController = navController)
                    }
                    composable(
                        Screen.UserSignUpScreen.route
                    ){
                        UserSignUpScreen(navController = navController, context = this@MainActivity)
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