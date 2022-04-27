package com.example.publicproblemtrackingapp.view.screens

sealed class Screen(val route:String){
    object HomeScreen : Screen("home_screen")
    object UserScreen : Screen("user_screen")
    object AdminScreen : Screen("admin_screen")
    object UserRegisterScreen : Screen("user_register_screen")
    object AdminRegisterScreen : Screen("admin_register_screen")
    object UserLoginScreen : Screen("user_login_screen")
    object AdminLoginScreen : Screen("admin_login_screen")
    object MapScreen : Screen("map_screen")
}
