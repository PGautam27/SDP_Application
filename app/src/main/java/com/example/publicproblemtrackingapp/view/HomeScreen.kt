package com.example.publicproblemtrackingapp.view.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.example.publicproblemtrackingapp.view.screens.Screen
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Yellow)
    ) {
        Text(
            AnnotatedString(text = "Welcome to ", spanStyle = SpanStyle(fontSize = LocalConfiguration.current.fontScale.times(20).sp, fontWeight = FontWeight.Bold)).plus(
                AnnotatedString(
                    text = "Problem Tracker",
                    spanStyle = SpanStyle(color = Orange,fontSize = LocalConfiguration.current.fontScale.times(30).sp,fontWeight = FontWeight.Bold)
                )
            )
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Which one are you ?", style = TextStyle(fontSize = LocalConfiguration.current.fontScale.times(20).sp,fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.padding(10.dp))
        FlowRow(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally), mainAxisSpacing = 20.dp, mainAxisAlignment = MainAxisAlignment.Center) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp/2 - 30.dp)
            ) {
                Text(text = "ADMIN", style = TextStyle(fontWeight = FontWeight.Bold))
            }
            Button(
                onClick = { navController.navigate(Screen.UserScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp/2 - 30.dp)
            ) {
                Text(text = "USER")
            }
        }
    }

}