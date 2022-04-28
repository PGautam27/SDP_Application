package com.example.publicproblemtrackingapp.presentation.screens

sealed class Screen(val route:String){
    object HomeScreen : Screen("home_screen")
    object UserScreen : Screen("user_screen")
    object AdminScreen : Screen("admin_screen")
    object UserSignUpScreen : Screen("user_sign_up_screen")
    object AdminHomeScreen : Screen("admin_Home_screen")
    object UserLoginScreen : Screen("user_login_screen")
    object AdminLoginScreen : Screen("admin_login_screen")
    object UserHomeScreen : Screen("user_home_screen")
    object ReportProblemScreen : Screen("report_problem_screen")
}
