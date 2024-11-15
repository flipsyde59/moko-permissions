
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose)
    alias(libs.plugins.android)
}

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "dev.icerock.moko.samples.permissions"
        minSdk = 21
        versionCode = 1
        versionName = "0.1.0"
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
    namespace = "com.icerockdev"
}
kotlin {
    jvmToolchain(17)
}
dependencies {
    implementation(libs.appCompat)
    implementation(libs.composeActivity)
    implementation(libs.composeMaterial)
    api(libs.mvvmCoreAndroid)
    implementation(project(":permissions-compose"))
    implementation(project(":sample:mpp-library"))
}