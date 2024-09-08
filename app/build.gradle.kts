plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.dndhandbook"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dndhandbook"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".dev"
            isDebuggable = true
            isMinifyEnabled = false
        }
    }

    flavorDimensions += "version"
    productFlavors {
        create("dev") {
            dimension = "version"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            resValue("string", "app_name", "[Dev] D&D Handbook")
            buildConfigField("String", "BASE_DND_URL", "\"https://www.dnd5eapi.co\"")
        }

        create("prod") {
            dimension = "version"
            resValue("string", "app_name", "D&D Handbook")
            buildConfigField("String", "BASE_DND_URL", "\"https://www.dnd5eapi.co\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation (libs.androidx.hilt.navigation.compose)

    // Navigation
    implementation(libs.androidx.navigation.compose)

    // Coil
    implementation(libs.coil.kt.coil.compose)

    // Gson
    implementation(libs.gson)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.logging.interceptor)
    implementation (libs.converter.moshi)
    implementation (libs.retrofit2.kotlin.coroutines.adapter)
    implementation (libs.converter.gson)
    implementation (libs.moshi.kotlin)
    //noinspection KaptUsageInsteadOfKsp
    kapt (libs.moshi.kotlin.codegen)

    // Stetho
    implementation (libs.stetho)
    implementation (libs.stetho.okhttp3)

    implementation (libs.grpc.okhttp)
}

kapt {
    correctErrorTypes = true
}
