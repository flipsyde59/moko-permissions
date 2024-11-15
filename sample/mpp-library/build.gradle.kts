import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("dev.icerock.moko.gradle.detekt")
}
kotlin {
    androidTarget()
    jvm("desktop")
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    targetHierarchy.default()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                api(libs.mokoMvvmCore)
                api(projects.permissions)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.lifecycle)
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val desktopMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.mokoMvvmTest)
                implementation(projects.permissionsTest)
            }
        }
    }
}
android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
framework {
    export(projects.permissions)
    export(libs.mokoMvvmCore)
}
