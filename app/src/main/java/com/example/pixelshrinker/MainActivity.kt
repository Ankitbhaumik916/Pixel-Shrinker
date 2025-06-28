package com.example.pixelshrinker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Optional: wrap in your theme if you want
            // PixelShrinkerTheme {
            var currentScreen by remember { mutableStateOf<Screen>(Screen.Welcome) }

            when (currentScreen) {
                is Screen.Welcome -> WelcomeScreen(
                    onCreateProfile = { currentScreen = Screen.CreateProfile },
                    onLogin = { currentScreen = Screen.Login }
                )
                is Screen.CreateProfile -> CreateProfileScreen(
                    onNext = { currentScreen = Screen.EmailPassword }
                )
                is Screen.EmailPassword -> EmailPasswordScreen(
                    onSave = { currentScreen = Screen.Welcome }
                )
                is Screen.Login -> LoginScreen(
                    onLogin = { currentScreen = Screen.Welcome }
                )
            }
            // }
        }
    }
}
