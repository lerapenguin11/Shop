plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
    id ("kotlin-android")
}

android {
    namespace = "com.example.shop"
    compileSdk = 34

    buildFeatures {
        aidl = true
    }

    defaultConfig {
        applicationId = "com.example.shop"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    /*implementation(project(":common:common_utils"))*/
    implementation(project(":feature_auth:auth_presentation"))
    implementation(project(":feature_home:home_presentation"))
    implementation(project(":feature_catalog:catalog_presentation"))
    implementation(project(":feature_basket:basket_presentation"))
    implementation(project(":feature_stocks:stocks_presentation"))
    implementation(project(":feature_profile:profile_presentation"))
    implementation(project(":feature_auth:auth_domain"))
    implementation(project(":feature_auth:auth_data"))
    implementation(project(":navigation"))

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.constraintLayout)
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
    implementation(Deps.fragment)
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)
    kapt(DaggerHilt.hiltCompiler)
    implementation(Coroutines.kotlin_stdlib)
    api(Navigation.nav_features)
    api(Navigation.nav_fragment)
    api(Navigation.nav_ui)
    implementation(Room.room)
    kapt(Room.roomCompiler)
}