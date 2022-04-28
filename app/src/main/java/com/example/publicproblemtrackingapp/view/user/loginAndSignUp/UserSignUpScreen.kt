package com.example.publicproblemtrackingapp.view.user.loginAndSignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.example.publicproblemtrackingapp.view.screens.Screen
import com.example.publicproblemtrackingapp.view.user.components.NavBackIcon

@Composable
fun UserSignUpScreen(navController: NavController) {
    val mobileNumberValue = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            NavBackIcon(navController = navController)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Yellow),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Enter Your MailId", fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(1.dp))
            OutlinedTextField(
                value = mobileNumberValue.value,
                onValueChange = {
                    mobileNumberValue.value = it
                },
                placeholder = {
                    Text(
                        text = "xyz@gmail.com",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                label = { Text(text = "Email ID", fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Orange,
                    unfocusedBorderColor = Orange,
                    unfocusedLabelColor = Orange,
                    focusedLabelColor = Orange
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, baselineShift = BaselineShift.None, fontSize = LocalConfiguration.current.fontScale.times(20).sp,  )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Password", fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(1.dp))
            OutlinedTextField(
                value = mobileNumberValue.value,
                onValueChange = {
                    mobileNumberValue.value = it
                },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text(text = "Password", fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Orange,
                    unfocusedBorderColor = Orange,
                    unfocusedLabelColor = Orange,
                    focusedLabelColor = Orange
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                maxLines = 1,
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, baselineShift = BaselineShift.None, fontSize = LocalConfiguration.current.fontScale.times(20).sp,  )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { navController.navigate(Screen.UserHomeScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow
                ),
                modifier = Modifier
                    .height(LocalConfiguration.current.screenHeightDp.dp / 15)
                    .width(
                        LocalConfiguration.current.screenWidthDp.dp - 200.dp
                    )
            ) {
                Text(text = "SIGN UP", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = LocalConfiguration.current.fontScale.times(15).sp))
            }
        }
    }
}