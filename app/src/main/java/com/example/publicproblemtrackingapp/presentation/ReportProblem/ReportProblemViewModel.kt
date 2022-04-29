package com.example.publicproblemtrackingapp.presentation.ReportProblem

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.publicproblemtrackingapp.data.dto.ReportProblem
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow

class ReportProblemViewModel():ViewModel() {
    private val database = Firebase.database
    private val myRef = database.getReference("Report Problem")

    fun updateData(problemCategory:String,reason : String,location:String,date:String){
        val reportProblem = ReportProblem(problemCategory,date,location,reason)
        myRef.child(problemCategory).setValue(reportProblem)
    }

}