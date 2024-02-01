plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
    id ("kotlin-android")
}

android {
    namespace = "com.example.auth_presentation"
    compileSdk = 34

    buildFeatures {
        aidl = true
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(project(":feature_auth:auth_domain"))
    implementation(project(":navigation"))
    implementation(project(":feature_catalog:catalog_presentation"))

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
    testImplementation(TestImplementation.junit)
    implementation(Deps.fragment)
    api(Navigation.nav_features)
    api(Navigation.nav_fragment)
    api(Navigation.nav_ui)
    implementation(Libraries.santalu_maskara)
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)
    kapt(DaggerHilt.hiltCompiler)
    implementation(Coroutines.kotlin_stdlib)
    implementation(Coroutines.lifecycle_viewmodel)
    implementation(Coroutines.lifecycle_livedata)
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifeCycleRuntime)
    implementation (ViewModelDelegate.viewModelDeligate)
}