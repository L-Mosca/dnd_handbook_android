plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    kotlin("plugin.serialization") version "2.0.21"
    id("androidx.room")
    id("com.google.firebase.crashlytics")
    id("com.google.gms.google-services")
}

android {

    signingConfigs {
        create("release") {
            storeFile = file("./key/dnd_android_key.jks")
            storePassword = "DND@handbook123"
            keyAlias = "DND@handbook123"
            keyPassword = "DND@handbook123"
        }
    }

    namespace = "com.moscatech.dndhandbook"
    compileSdk = 36

    room {
        schemaDirectory("$projectDir/schemas")
    }

    defaultConfig {
        applicationId = "com.moscatech.dndhandbook"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "BASE_DND_URL", "\"https://www.dnd5eapi.co\"")
        buildConfigField("String", "BASE_DEEP_LINK", "\"https://dnd_handbook/monsterDetailDeepRoute\"")

        buildConfigField("String", "API_DOC", "\"https://5e-bits.github.io/docs/\"")
        buildConfigField("String", "API_REPO", "\"https://github.com/5e-bits/5e-srd-api\"")
        buildConfigField("String", "DATABASE_REPO", "\"https://github.com/5e-bits/5e-database\"")
        buildConfigField("String", "PRIVACY_POLICIES", "\"https://www.termsfeed.com/live/e25fc1ee-3088-4dfa-83e7-146871bd222a\"")
    }
    packaging {
        resources {
            excludes += setOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/DEPENDENCIES",
                "META-INF/LICENSE",
                "META-INF/NOTICE"
            )
        }
    }

    /*packagingOptions {
        exclude 'META-INF/DEPENDENCIES'
        exclude 'META-INF/LICENSE' // Often, LICENSE and NOTICE files also cause conflicts
        exclude 'META-INF/NOTICE'
    }*/

    buildTypes {
        release {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
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
        }

        create("prod") {
            dimension = "version"
            resValue("string", "app_name", "D&D Handbook")
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
    implementation(libs.androidx.browser)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
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

    // Stetho
    implementation (libs.stetho)
    implementation (libs.stetho.okhttp3)
    implementation (libs.grpc.okhttp)

    // Preferences Data Store
    implementation(libs.androidx.datastore.preferences)

    // Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.androidx.room.testing)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.coil.gif)

    // Lottie
    implementation(libs.lottie.compose)

    // Open PDF
    implementation(libs.pdfbox.android)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.database)
    implementation(libs.firebase.crashlytics.ndk)
}
