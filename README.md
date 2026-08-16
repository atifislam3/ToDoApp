# ✅ ToDoApp - Modern Task Management

A sleek, offline-first Android application designed to help you stay organized. Built with **Jetpack Compose**, **Room**, and **Kotlin Coroutines**, this app follows the **MVVM architecture** with a clean **Repository pattern** for robust and scalable performance.

---

## ✨ Features

- **🚀 Performance-First**: Instant loading and smooth animations using Jetpack Compose.
- **💾 Offline Persistence**: Your data stays on your device using Room SQLite.
- **✍️ Seamless Editing**: Intuitive bottom-sheet editor to create or modify tasks.
- **✅ Interactive Tasks**: Toggle completion with strike-through animations and color feedback.
- **🗑️ Smart Management**: Easily delete tasks with a dedicated red action button.
- **📊 Progress Tracking**: Real-time counter showing remaining tasks and a "All done! 🎉" celebration state.
- **🎨 Modern Design**: Material 3 components with a clean, high-contrast UI and soft shadows.

---

## 🛠 Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/docs/home.html)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Database**: [Room Persistence Library](https://developer.android.com/training/data-storage/room)
- **Architecture**: MVVM (Model-View-ViewModel) + Repository Pattern
- **Threading**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)
- **Dependency Management**: Gradle Kotlin DSL + [Version Catalogs](https://docs.gradle.org/current/userguide/platforms.html)
- **Code Generation**: [KSP (Kotlin Symbol Processing)](https://kotlinlang.org/docs/ksp-overview.html)

---

## 🏗 Project Structure

The project is organized into layers to follow Clean Architecture principles:

```text
com.atif.todoapp
├── data/           # Room Entity, DAO, and Database configuration
├── repository/     # Data source abstraction layer
├── ui/
│   ├── screens/    # Jetpack Compose UI Screens (List, Item, Editor)
│   └── theme/      # Custom Material3 Theme, Colors, and Typography
└── viewmodel/      # Business logic and UI state management
```

---

## 🚀 Getting Started

### Prerequisites
- **Android Studio Ladybug** | 2024.2.1 or newer
- **JDK 17**
- **Android API Level 26+** (Oreo and above)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/atifislam3/ToDoApp.git
   ```
2. Open the project in **Android Studio**.
3. Allow the Gradle sync to finish.
4. Select your device and click **Run**.

---

## 🤝 Contributing
Contributions are welcome! If you'd like to improve the UI or add features:
1. Fork the project.
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the Branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

---

Developed with ❤️ using **Kotlin**.
