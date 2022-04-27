package com.example.publicproblemtrackingapp.view.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFDD835))
    ) {
        Text(
            AnnotatedString(text = "Welcome to ", spanStyle = SpanStyle(fontSize = 20.sp)).plus(
                AnnotatedString(
                    text = "Problem Tracker",
                    spanStyle = SpanStyle(color = Color(0xFFFF9800),fontSize = 25.sp)
                )
            )
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = "Which one are you ?", style = TextStyle(fontSize = 20.sp))
        Spacer(modifier = Modifier.padding(10.dp))
        FlowRow(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally), mainAxisSpacing = 20.dp, mainAxisAlignment = MainAxisAlignment.Center) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF9800),
                    contentColor = Color(0xFFFDD835)
                )
            ) {
                Text(text = "ADMIN")
            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF9800),
                    contentColor = Color(0xFFFDD835)
                )
            ) {
                Text(text = "USER")
            }
        }
    }

}