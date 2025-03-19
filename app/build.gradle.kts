plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.walmartapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.walmartapplication"
        minSdk = 29
        targetSdk = 35
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
        viewBinding = true
    }
}

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.google.material)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.androidx.fragment.ktx)

        // Retrofit
        implementation(libs.bundles.retrofit)

        // Coroutines
        implementation(libs.bundles.coroutines)

        // Lifecycle
        implementation(libs.bundles.lifecycle)

        // Testing
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.test.ext)
        androidTestImplementation(libs.androidx.test.espresso)
    }