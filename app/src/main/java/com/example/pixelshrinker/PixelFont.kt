package com.example.pixelshrinker

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont

val fontName = GoogleFont("Press Start 2P")

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val PixelFont = FontFamily(
    androidx.compose.ui.text.googlefonts.Font(
        googleFont = fontName,
        fontProvider = provider
    )
)
