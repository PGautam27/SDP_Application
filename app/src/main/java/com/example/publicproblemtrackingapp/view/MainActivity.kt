package com.example.publicproblemtrackingapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.publicproblemtrackingapp.ui.theme.PublicProblemTrackingAppTheme
import com.example.publicproblemtrackingapp.view.HomeScreen.HomeScreen
import com.example.publicproblemtrackingapp.view.screens.Screen
import com.example.publicproblemtrackingapp.view.user.UserScreen
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

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