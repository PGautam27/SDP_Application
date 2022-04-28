package com.example.publicproblemtrackingapp.presentation.ReportProblem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.publicproblemtrackingapp.ui.theme.Yellow

@Composable
fun ReportProblemScreen() {
    Column(
        modifier = Modifier
            .background(color = Yellow)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "REPORT THE PROBLEM", fontSize = LocalConfiguration.current.fontScale.times(25).sp)
        Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/30))

    }
}