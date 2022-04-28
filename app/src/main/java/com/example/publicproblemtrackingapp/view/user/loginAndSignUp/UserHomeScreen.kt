package com.example.publicproblemtrackingapp.view.user.loginAndSignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment
import com.google.accompanist.flowlayout.MainAxisAlignment

@Composable
fun UserHomeScreen(navController: NavController) {
    val buttonNames = listOf<String>("Profile","Edit Profile","Report a Problem","LogOut")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttonNames.forEach { it ->
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier
                    .height(LocalConfiguration.current.screenHeightDp.dp / 8)
                    .width(
                        LocalConfiguration.current.screenWidthDp.dp - 40.dp
                    )
            ) {
                Text(text = it, style = TextStyle(fontWeight = FontWeight.Bold), fontSize = LocalConfiguration.current.fontScale.times(22).sp)
            }
            Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/27))
        }
    }
}