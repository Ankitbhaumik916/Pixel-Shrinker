package com.example.pixelshrinker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CompressionScreen(
    onCompress: (CompressionMode, Uri?) -> Unit
) {
    var selectedMode by remember { mutableStateOf<CompressionMode?>(null) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        selectedImageUri = uri
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RetroBlack)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "IMAGE COMPRESSION",
                style = TextStyle(
                    fontFamily = pixelFont,
                    color = NeonGreen,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { imagePickerLauncher.launch("image/*") },
                colors = ButtonDefaults.buttonColors(containerColor = NeonGreen),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text(
                    text = "SELECT IMAGE",
                    style = TextStyle(
                        fontFamily = pixelFont,
                        color = RetroBlack,
                        fontSize = 12.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            selectedImageUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Selected Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.DarkGray)
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Estimated Size: ~1.2 MB",
                    style = TextStyle(
                        fontFamily = pixelFont,
                        color = NeonGreen,
                        fontSize = 12.sp
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            CompressionOption("LOSSLESS", CompressionMode.LOSSLESS, selectedMode) {
                selectedMode = it
            }
            CompressionOption("LOSSY", CompressionMode.LOSSY, selectedMode) {
                selectedMode = it
            }
            CompressionOption("EXTREME", CompressionMode.EXTREME, selectedMode) {
                selectedMode = it
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    onCompress(selectedMode ?: CompressionMode.LOSSLESS, selectedImageUri)
                },
                enabled = selectedImageUri != null && selectedMode != null,
                colors = ButtonDefaults.buttonColors(containerColor = NeonGreen),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(50.dp)
            ) {
                Text(
                    text = "COMPRESS",
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
