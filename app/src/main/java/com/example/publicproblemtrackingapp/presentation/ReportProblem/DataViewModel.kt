package com.example.publicproblemtrackingapp.presentation.ReportProblem

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.publicproblemtrackingapp.data.dto.ReportProblem
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow

class DataViewModel():ViewModel() {
    private lateinit var reportProblem: ReportProblem
    private val database = Firebase.database
    private val myRef = database.getReference("Report Problem")

    private lateinit var category : String
    private lateinit var date : String
    private lateinit var location: String
    private lateinit var reason: String

    fun updateData(problemCategory:String,reason : String,location:String,date:String){
        val reportProblem = ReportProblem(problemCategory,date,location,reason)
        myRef.child(problemCategory).setValue(reportProblem)
    }

    fun getData(){
        myRef.child("Road Problem").get()
            .addOnSuccessListener {
                it.children.forEach { i->
                    when (i.key) {
                        "category" -> category = i.value.toString()
                        "date" -> date = i.value.toString()
                        "location" -> location = i.value.toString()
                        "reason" -> reason = i.value.toString()
                        else -> return@forEach
                    }
                    Log.d("Problem","${i}")
                }
                Log.d("Problem","${it.toString()}")
            }
    }
}