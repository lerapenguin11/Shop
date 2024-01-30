plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.common_utils"
    compileSdk = 34

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
            buildConfigField("String", "API_URL", "\"https://run.mocky.io/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010\"")
        }
        debug {
            buildConfigField("String", "API_URL", "\"https://run.mocky.io/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)
    kapt(DaggerHilt.hiltCompiler)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.gsonConvertor)
    implementation(Retrofit.okHttp)
    implementation(Retrofit.scalersConvertors)
    implementation(Retrofit.converter_moshi)
    implementation(Retrofit.moshi)
    implementation(Retrofit.moshi_adapter)
    implementation(Retrofit.okhttp_logging)
    implementation(Retrofit.kotlin_coroutine_adapter)
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)
    implementation(Coroutines.kotlin_stdlib)
}