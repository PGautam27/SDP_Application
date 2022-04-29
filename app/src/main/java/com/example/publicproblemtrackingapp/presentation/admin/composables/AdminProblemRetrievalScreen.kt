package com.example.publicproblemtrackingapp.presentation.admin.adminProblemRetrieval

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.publicproblemtrackingapp.data.dto.ReportProblem
import com.example.publicproblemtrackingapp.presentation.ReportProblem.DataViewModel
import com.example.publicproblemtrackingapp.ui.theme.Orange
import com.example.publicproblemtrackingapp.ui.theme.Yellow
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun AdminProblemRetrievalScreen(context: ComponentActivity) {
    val database = Firebase.database
    val myRef = database.getReference("Report Problem")
    val location = remember{ mutableStateOf("")}
    val date = remember{ mutableStateOf("")}
    val reason = remember{ mutableStateOf("")}
    val problem = remember { mutableStateOf("")}
    val reportProblemValue = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Search Your Problem Category", fontSize = LocalConfiguration.current.fontScale.times(25).sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = reportProblemValue.value,
            onValueChange = {
                reportProblemValue.value = it
            },
            placeholder = {
                Text(
                    text = "Problem Name",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            },
            label = { Text(text = "Problem Name", fontWeight = FontWeight.Bold) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Orange,
                unfocusedBorderColor = Orange,
                unfocusedLabelColor = Orange,
                focusedLabelColor = Orange
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            maxLines = 1,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        myRef.child(reportProblemValue.value).get()
                            .addOnSuccessListener {
                                if (!it.exists()){
                                    Toast.makeText(context, "Problem Doesn't Exist",
                                        Toast.LENGTH_SHORT).show()
                                }
                                it.children.forEach { i->
                                    when (i.key) {
                                        "category" -> problem.value = i.value.toString()
                                        "date" -> date.value = i.value.toString()
                                        "location" -> location.value = i.value.toString()
                                        "reason" -> reason.value = i.value.toString()
                                        else -> return@forEach
                                    }
                                }
                            }
                    })
            },
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, baselineShift = BaselineShift.None, fontSize = LocalConfiguration.current.fontScale.times(20).sp,)
        )
        Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/38))
        Divider(color = Orange, thickness = 2.dp, modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp -80.dp))
        Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/38))
        Text(text = "Problem Information's : ", fontSize = LocalConfiguration.current.fontScale.times(30).sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/40))
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp - 150.dp)) {
            Text(
                AnnotatedString(
                    text = "Problem Name :",
                    spanStyle = SpanStyle(
                        fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                        fontWeight = FontWeight.Bold
                    )
                ).plus(
                    AnnotatedString(
                        problem.value,
                        spanStyle = SpanStyle(
                            fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/42))
            Text(
                AnnotatedString(
                    text = "Reason :",
                    spanStyle = SpanStyle(
                        fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                        fontWeight = FontWeight.Bold
                    )
                ).plus(
                    AnnotatedString(
                        reason.value,
                        spanStyle = SpanStyle(
                            fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/42))
            Text(
                AnnotatedString(
                    text = "Location :",
                    spanStyle = SpanStyle(
                        fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                        fontWeight = FontWeight.Bold
                    )
                ).plus(
                    AnnotatedString(
                        location.value,
                        spanStyle = SpanStyle(
                            fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.padding(LocalConfiguration.current.screenHeightDp.dp/42))
            Text(
                AnnotatedString(
                    text = "Date :",
                    spanStyle = SpanStyle(
                        fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                        fontWeight = FontWeight.Bold
                    )
                ).plus(
                    AnnotatedString(
                        date.value,
                        spanStyle = SpanStyle(
                            fontSize = LocalConfiguration.current.fontScale.times(20).sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                )
            )
        }
    }
}