plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}


android {
    namespace = "com.example.klikkinpruebatecnica"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.klikkinpruebatecnica"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    val koinVersion = "2.2.3"
    val koinViewModelVersion = "2.2.3"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.compose.material3:material3:1.0.1")

    //FragmentViewDelegate
    implementation("com.github.Zhuinden:fragmentviewbindingdelegate-kt:1.0.2")

    //Koin
    implementation("io.insert-koin:koin-androidx-viewmodel:$koinViewModelVersion")
    implementation ("io.insert-koin:koin-android:$koinVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Retrofit with Moshi Converter
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")
    //GSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Corroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

}