plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.daggerroom"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.daggerroom"
        minSdk = 27
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
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
   ksp(libs.androidx.room.compiler)

    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.fragment.ktx)
    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    // Local Unit Tests
    implementation (libs.androidx.core)
    testImplementation (libs.junit)
    testImplementation (libs.hamcrest.all)
    testImplementation (libs.androidx.core.testing)
    testImplementation (libs.robolectric)
    testImplementation (libs.kotlinx.coroutines.test)
    testImplementation (libs.truth)
    testImplementation (libs.mockito.core)

    // Instrumented Unit Tests
    androidTestImplementation (libs.junit)

    androidTestImplementation (libs.kotlinx.coroutines.test)
    androidTestImplementation (libs.androidx.core.testing)
    androidTestImplementation (libs.truth)

    androidTestImplementation (libs.mockito.core)

}