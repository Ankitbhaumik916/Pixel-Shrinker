package com.example.pixelshrinker

sealed class Screen {
    object Welcome : Screen()
    object CreateProfile : Screen()
    object EmailPassword : Screen()
    object Login : Screen()
}
