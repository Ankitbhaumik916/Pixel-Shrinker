# 🎮 PixelShrinker

PixelShrinker is a **Retro Pixel-Style Image Compressor** app for Android, built with **Jetpack Compose** and **Kotlin**.  
It allows users to:
- Create a profile and log in
- Pick an image from their device
- Choose between different compression modes:
  - 🟢 Lossless
  - 🟡 Lossy
  - 🔴 Extreme
- Compress images while previewing estimated file sizes

This project is designed with a **pixelated UI aesthetic** inspired by early gaming interfaces.

---

## ✨ Features

✅ Retro pixel font (`Press Start 2P`)  
✅ Neon green-on-black color palette  
✅ Profile creation and login screens  
✅ Compression mode selection UI  
✅ Modular Composables ready for image picker integration

---

## 📷 Screenshots

> *(Add screenshots here once you have the app running)*

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Google Fonts API** for retro fonts
- **Material3**
- Android Studio

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or newer
- Minimum SDK 24+
- Internet connection for downloading Google Fonts on first launch

---

### Build Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/PixelShrinker.git
   cd PixelShrinker
Open in Android Studio

Sync Gradle

Make sure you have this dependency in build.gradle:

gradle
Copy
Edit
implementation "androidx.compose.ui:ui-text-google-fonts:1.6.1"
Run the app

🖼️ How It Works
On launch, the app displays a Welcome Screen to create a profile or log in.

Compression Screen shows selectable modes.

When you tap Compress, the app processes the selected image.

Font loads dynamically via Google Fonts (requires internet first time).

📝 Future Improvements
Add file picker to select images

Show image previews and size estimates

Implement actual compression algorithms

Save compressed files to storage

Dark/light theme toggle

Multi-language support

📄 License
MIT License
Copyright (c) 2025 Ankit Bhaumik

