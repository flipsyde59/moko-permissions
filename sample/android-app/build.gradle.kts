plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android)
    id("kotlin-kapt")
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "com.icerockdev.sample.app"
    buildFeatures {
        dataBinding = true
    }
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "dev.icerock.moko.samples.permissions"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "0.1.0"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.appCompat)
    implementation(libs.material)

    implementation(project(":sample:mpp-library"))
}
