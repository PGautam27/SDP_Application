package com.example.publicproblemtrackingapp.presentation.ReportProblem

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow

@Composable
fun ReportProblemScreen(viewModel: ReportProblemViewModel = ReportProblemViewModel(), context : ComponentActivity) {
    val categoryValue = remember{ mutableStateOf("") }
    val reasonValue = remember { mutableStateOf("") }
    val locationValue = remember{ mutableStateOf("") }
    val dateValue = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter your Problem information",
                fontSize = LocalConfiguration.current.fontScale.times(25).sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/30))
            TextField(
                value = categoryValue.value,
                onValueChange = { categoryValue.value = it },
                placeholder = { Text(text = "Category", color = Color.Black) },
                label = { Text(text = "Which Category", color = Color.Black)},
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFFF5722),
                    focusedIndicatorColor = Color(0xFFFF5722),
                    backgroundColor = Color(0x8BFF9800)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 11.dp,
                            topEnd = 11.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ),
                textStyle = TextStyle(
                    color = Color.Black
                )
            )
            TextField(
                value = reasonValue.value,
                onValueChange = { reasonValue.value = it },
                placeholder = { Text(text = "Reason", color = Color.Black) },
                label = { Text(text = "Reason", color = Color.Black) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFFF5722),
                    focusedIndicatorColor = Color(0xFFFF5722),
                    backgroundColor = Color(0x8BFF9800)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                textStyle = TextStyle(
                    color = Color.Black
                )
            )
            TextField(
                value = locationValue.value,
                onValueChange = { locationValue.value = it },
                placeholder = { Text(text = "Location", color = Color.Black) },
                label = { Text(text = "Location", color = Color.Black) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFFF5722),
                    focusedIndicatorColor = Color(0xFFFF5722),
                    backgroundColor = Color(0x8BFF9800)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.85f),
                textStyle = TextStyle(
                    color = Color.Black
                )
            )
            TextField(
                value = dateValue.value,
                onValueChange = { dateValue.value = it },
                placeholder = { Text(text = "Date",color = Color.Black) },
                label = { Text(text = "Date", color = Color.Black) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFFF5722),
                    focusedIndicatorColor = Color(0xFFFF5722),
                    backgroundColor = Color(0x8BFF9800)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 11.dp,
                            bottomEnd = 11.dp
                        )
                    ),
                textStyle = TextStyle(
                    color = Color.Black
                )
            )
        }
        Spacer(modifier =Modifier.height(35.dp))
        Button(
            onClick = {
                viewModel.updateData(
                    problemCategory = categoryValue.value,
                    reason = reasonValue.value,
                    location = locationValue.value,
                    date = dateValue.value
                )
                Toast.makeText(
                    context, "Sent Successfully",
                    Toast.LENGTH_SHORT
                ).show()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange,
                contentColor = Yellow
            ),
            modifier = Modifier
                .height(LocalConfiguration.current.screenHeightDp.dp / 10)
                .width(
                    LocalConfiguration.current.screenWidthDp.dp - 250.dp
                )
                .clip(RoundedCornerShape(15.dp))
        ) {
            Text(
                text = "SUBMIT",
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = LocalConfiguration.current.fontScale.times(20).sp
            )
        }
    }
}