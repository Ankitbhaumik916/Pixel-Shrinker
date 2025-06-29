package com.example.pixelshrinker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationCompat



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ Always create the notification channel before showing notifications
        createNotificationChannel()

        setContent {
            val context = LocalContext.current

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
                    onSave = { currentScreen = Screen.Compression }
                )

                is Screen.Login -> LoginScreen(
                    onLogin = { currentScreen = Screen.Compression }
                )

                is Screen.Compression -> CompressionScreen { mode, uri ->
                    if (uri != null) {
                        val file = compressImage(context, uri, mode)
                        if (file != null) {
                            // Show Notification
                            val notificationManager =
                                getSystemService(NotificationManager::class.java)
                            val builder =
                                NotificationCompat.Builder(this@MainActivity, "compression_channel")
                                    .setSmallIcon(android.R.drawable.stat_sys_download_done)
                                    .setContentTitle("Compression Complete")
                                    .setContentText("Saved to: ${file.name}")
                                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                            notificationManager.notify(1, builder.build())

                            // Also show a toast
                            Toast.makeText(
                                context,
                                "Compressed saved at: ${file.absolutePath}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }



                        // ✅ Moved inside MainActivity
    private fun createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = android.app.NotificationChannel(
                "compression_channel",
                "Compression Notifications",
                android.app.NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notifications when image compression completes."
            }
            val notificationManager = getSystemService(android.app.NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
