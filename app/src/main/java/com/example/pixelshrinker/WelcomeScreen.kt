package com.example.pixelshrinker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun WelcomeScreen(
    onCreateProfile: () -> Unit,
    onLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RetroBlack)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "PIXELSHRINKER",
                style = TextStyle(
                    fontFamily = pixelFont,
                    color = NeonGreen,
                    fontSize = 20.sp
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { onCreateProfile() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = NeonGreen
                ),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(60.dp)
            ) {
                Text(
                    "CREATE PROFILE",
                    style = TextStyle(
                        fontFamily = pixelFont,
                        color = RetroBlack,
                        fontSize = 12.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { onLogin() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = NeonPink
                ),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(60.dp)
            ) {
                Text(
                    "LOGIN",
                    style = TextStyle(
                        fontFamily = pixelFont,
                        color = RetroBlack,
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}
