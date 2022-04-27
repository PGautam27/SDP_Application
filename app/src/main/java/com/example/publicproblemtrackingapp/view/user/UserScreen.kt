package com.example.publicproblemtrackingapp.view.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow

@Composable
fun UserScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = Yellow)
            .fillMaxSize()
    ) {
        Text(text = "Already Have an Account")
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange,
                contentColor = Yellow
            ),
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp / 8)
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 10.dp
                )
        ) {
            Text(text = "LOGIN")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Divider(color = Orange, thickness = 2.dp)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Don't have One?")
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange,
                contentColor = Yellow
            ),
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp / 8)
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 10.dp
                )
        ) {
            Text(text = "SIGN UP")
        }
    }
}