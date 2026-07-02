# Android Espresso Automation Project

This repository contains an automated testing suite for an Android application using **Espresso** and **Kotlin**. The project is structured using the **Page Object Model (POM)** pattern (Robot pattern) and is integrated with **GitHub Actions** for CI/CD, executing tests on **BrowserStack**.

## 🚀 Features

- **Framework:** Espresso
- **Language:** Kotlin
- **Pattern:** Robot Pattern (Page Object Model)
- **CI/CD:** GitHub Actions
- **Cloud Testing:** BrowserStack App Automate

## 📁 Project Structure

- `app/src/main`: Main application source code.
- `app/src/androidTest`: Instrumental tests.
  - `.../pageObjects/Login/robot`: Contains the Robot classes (Actions/Interactions).
  - `.../pageObjects/Login/constants`: Contains the constants and strings used in tests.
  - `.../pageObjects/Login/`: Contains the test execution classes (e.g., `TesteLogin.kt`).

## 🛠️ Prerequisites

- Android Studio
- JDK 17
- BrowserStack Account (Username and Access Key)

## 💻 How to Run Locally

To run the tests on your local emulator or physical device:

1. Clone the repository.
2. Open the project in Android Studio.
3. Build the project:
   ```bash
   ./gradlew assembleDebug assembleDebugAndroidTest
   ```
4. Run the tests:
   ```bash
   ./gradlew connectedDebugAndroidTest
   ```

## ⚙️ CI/CD Configuration (GitHub Actions)

The project includes a automated pipeline in `.github/workflows/browserstack.yml`. Every time you push to the `main` branch, the pipeline will:

1. Build the App APK.
2. Build the Test APK.
3. Upload both APKs to BrowserStack.
4. Execute the tests on a real device (**Samsung Galaxy S23**).

### Required GitHub Secrets

To make the pipeline work, you must add the following **Repository Secrets** in your GitHub repository (**Settings > Secrets and variables > Actions**):

- `BROWSERSTACK_USERNAME`: Your BrowserStack username.
- `BROWSERSTACK_ACCESS_KEY`: Your BrowserStack access key.

## 📄 License

This project is for educational and testing purposes.
