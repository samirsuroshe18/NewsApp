# 📰 News App

The News App is an Android application built using Jetpack Compose, MVVM, and Clean Architecture. It provides users with the latest news articles in a clean, modern, and user-friendly interface. This project serves as a hands-on learning experience to explore Compose UI, modular architecture, and best practices in Android development.

## 🎥 Demo
<p align="center">
  <a href="https://www.youtube.com/watch?v=oaX4AnNs5pE" target="_blank">
    <img src="https://img.shields.io/badge/Watch%20on%20YouTube-red?logo=youtube&logoColor=white&style=for-the-badge" alt="Watch on YouTube"/>
  </a>
</p>

## 📸 Screenshots
<p align="center">

  <img width="188" alt="onboarding" src="https://github.com/user-attachments/assets/c41d46b3-ea8f-463f-90d1-f87dde10b4c9" />
  <img width="188" alt="home" src="https://github.com/user-attachments/assets/3c7897a7-dbb6-4ccd-8677-6eace706f714" />
  <img width="188" alt="details" src="https://github.com/user-attachments/assets/29c71cc7-4594-449c-b229-0ba9a3ccf901" />
  <img width="188" alt="search" src="https://github.com/user-attachments/assets/16e08085-7140-4451-b453-0fbaf6cbff67" />
  <img width="188" alt="bookmark" src="https://github.com/user-attachments/assets/011f6bb9-d920-494d-8509-9a3f6148140c" />

</p>

## 📥 Download

<p align="center">
  <img width="80" height="80" alt="play_store_512" src="https://github.com/user-attachments/assets/617f56b6-d415-4add-8a14-d31b1a727f3c" />
  <br/><br/>
  <a href="https://github.com/samirsuroshe18/NewsApp/releases/latest">
    <img src="https://img.shields.io/badge/Download%20APK-blue?style=for-the-badge&logo=android" alt="Download APK"/>
  </a>
</p>

## 🚀 Features
- 📰 Browse latest news articles in real-time
- 🔍 Search news by keyword
- 📑 Read full articles with smooth UI
- 🌙 Dark/Light theme support
- 🔖 Bookmark articles to read later, saved on the device
- 👋 Onboarding screens on first launch

## 🛠️ Tech Stack
- **Language:** Kotlin  
- **UI:** Jetpack Compose 
- **Architecture:** MVVM + Clean Architecture
- **Networking:** Retrofit + OkHttp 
- **News source:** [NewsAPI](https://newsapi.org)
- **Lists:** Paging 3
- **Storage:** Room (bookmarks), DataStore (first-launch flag)
- **Async:** Coroutines + Flow
- **Dependency Injection:** Hilt 
- **Image Loading:** Coil  
- **IDE:** Android Studio  

## 📲 Installation
1. Download the APK from the [Releases](https://github.com/samirsuroshe18/NewsApp/releases/latest).  
2. Enable **installation from unknown sources** on your device.  
3. Tap the APK file to install it.  
4. Open the app and start reading. No account is needed.  

## ⚙️ For Developers (Setup Guide)
1. Clone this repo
   ```bash
   git clone https://github.com/samirsuroshe18/NewsApp.git
   ```
2. Open the project in Android Studio.
3. Get a key from [NewsAPI](https://newsapi.org) and set it as `API_KEY` in
   `app/src/main/java/in/smartdwell/newsapp/util/Constants.kt`.
4. Sync Gradle and run on an emulator or a device.

## 📬 Contact
👨‍💻 Developer: Samir Suroshe  
📧 Email: [sameersuroshe50@gmail.com](mailto:sameersuroshe50@gmail.com)  
🔗 LinkedIn: [samir-suroshe](https://www.linkedin.com/in/samir-suroshe)  

Your feedback and contributions are always welcome!

## License

[MIT](LICENSE)
