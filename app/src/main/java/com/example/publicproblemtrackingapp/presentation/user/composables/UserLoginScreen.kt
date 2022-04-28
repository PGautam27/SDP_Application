package com.example.publicproblemtrackingapp.presentation.user.composables

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.example.publicproblemtrackingapp.presentation.screens.Screen
import com.example.publicproblemtrackingapp.presentation.user.components.NavBackIcon
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun UserLoginScreen(navController: NavController,context: ComponentActivity) {
    val auth = Firebase.auth
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
            val emailValue = remember { mutableStateOf(TextFieldValue()) }
            val passwordValue = remember { mutableStateOf(TextFieldValue()) }
            val enabledValue = remember { mutableStateOf(false) }
            Text(text = "LOGIN SCREEN", fontSize = LocalConfiguration.current.fontScale.times(30).sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Enter Your MailId", fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(1.dp))
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = {
                    emailValue.value = it
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                maxLines = 1,
                textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, baselineShift = BaselineShift.None, fontSize = LocalConfiguration.current.fontScale.times(20).sp,  )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Password", fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(1.dp))
            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = {
                    passwordValue.value = it
                    if (emailValue.value!=null && passwordValue.value!=null){
                        enabledValue.value = true
                    }
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
                onClick = {
                   auth.signInWithEmailAndPassword(
                       emailValue.value.text.trim(),
                       passwordValue.value.text.trim()
                   ).addOnCompleteListener(context){task ->
                       if (task.isSuccessful){
                           Log.d("AUTH","SignInWithEmail : Success")
                           navController.navigate(Screen.UserHomeScreen.route)
                       }
                       else{
                           Log.w("SignInWithEmail:Failure",task.exception)
                           Toast.makeText(context, "SignIn failed.",
                               Toast.LENGTH_SHORT).show()
                       }
                   }
//                    navController.navigate(Screen.UserHomeScreen.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Orange,
                    contentColor = Yellow,
                    disabledBackgroundColor = Orange,
                    disabledContentColor = Yellow
                ),
                enabled = enabledValue.value,
                modifier = Modifier
                    .height(LocalConfiguration.current.screenHeightDp.dp / 15)
                    .width(
                        LocalConfiguration.current.screenWidthDp.dp - 200.dp
                    )
            ) {
                Text(text = "LOGIN", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = LocalConfiguration.current.fontScale.times(15).sp))
            }
        }
    }
}