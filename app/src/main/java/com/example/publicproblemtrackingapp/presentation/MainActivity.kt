package com.example.publicproblemtrackingapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.publicproblemtrackingapp.presentation.HomeScreen.HomeScreen
import com.example.publicproblemtrackingapp.presentation.ReportProblem.ReportProblemScreen
import com.example.publicproblemtrackingapp.presentation.admin.AdminHomeScreen
import com.example.publicproblemtrackingapp.presentation.admin.AdminLoginScreen
import com.example.publicproblemtrackingapp.presentation.admin.AdminScreen
import com.example.publicproblemtrackingapp.presentation.admin.adminProblemRetrieval.AdminProblemRetrievalScreen
import com.example.publicproblemtrackingapp.presentation.screens.Screen
import com.example.publicproblemtrackingapp.presentation.user.UserScreen
import com.example.publicproblemtrackingapp.presentation.user.composables.UserHomeScreen
import com.example.publicproblemtrackingapp.presentation.user.composables.UserLoginScreen
import com.example.publicproblemtrackingapp.presentation.user.composables.UserSignUpScreen
import com.example.publicproblemtrackingapp.ui.theme.PublicProblemTrackingAppTheme

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
                        UserLoginScreen(navController = navController, context = this@MainActivity)
                    }
                    composable(Screen.UserHomeScreen.route){
                        UserHomeScreen(navController = navController)
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
                    composable(
                        Screen.ReportProblemScreen.route
                    ){
                        ReportProblemScreen(context = this@MainActivity)
                    }
                    composable(
                        Screen.AdminProblemRetrievalScreen.route
                    ){
                        AdminProblemRetrievalScreen(context = this@MainActivity)
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