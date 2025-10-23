plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.gms.google-services") // 👈 ajoute ça
}

android {
    namespace = "com.example.gestionlivres"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.gestionlivres"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    // Firebase BoM (Bill of Materials, gère les versions)
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))

    // Firebase Auth
    implementation("com.google.firebase:firebase-auth")

    // Firestore (Base de données NoSQL)
    implementation("com.google.firebase:firebase-firestore")

    // Storage (images des livres)
    implementation("com.google.firebase:firebase-storage")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.8.0")
// Coil (images) — servira pour l’écran livres
    implementation("io.coil-kt:coil-compose:2.6.0")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.ui:ui-text")



}