package com.example.pixelshrinker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompressionOption(
    label: String,
    mode: CompressionMode,
    selectedMode: CompressionMode?,
    onSelect: (CompressionMode) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(vertical = 8.dp)
            .background(
                if (selectedMode == mode) NeonGreen else Color.DarkGray,
                RoundedCornerShape(4.dp)
            )
            .clickable { onSelect(mode) }
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontFamily = pixelFont,
                color = if (selectedMode == mode) RetroBlack else NeonGreen,
                fontSize = 12.sp
            )
        )
    }
}
