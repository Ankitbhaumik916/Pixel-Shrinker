package com.example.pixelshrinker

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

fun compressImage(
    context: Context,
    imageUri: Uri,
    compressionMode: CompressionMode
): File? {
    try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(imageUri)
        if (inputStream == null) return null

        val originalBitmap = BitmapFactory.decodeStream(inputStream)
        inputStream.close()

        val quality = when (compressionMode) {
            CompressionMode.LOSSLESS -> 100
            CompressionMode.LOSSY -> 60
            CompressionMode.EXTREME -> 30
        }

        val fileName = "compressed_${System.currentTimeMillis()}.jpg"

        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(downloadsDir, fileName)

        val outputStream = FileOutputStream(file)
        originalBitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
        outputStream.flush()
        outputStream.close()

        return file
    } catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}
