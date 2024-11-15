import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("dev.icerock.moko.gradle.stub.javadoc")
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
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.activity)
                implementation(libs.lifecycleRuntime)
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val desktopMain by getting
    }
}
val GITHUB_USER: String by project
val GITHUB_TOKEN: String by project
publishing {
    repositories {
        maven {
            setUrl("https://maven.pkg.github.com/flipsyde59/moko-permissions")
            credentials {
                username = GITHUB_USER
                password = GITHUB_TOKEN
            }
        }
    }
}
android {
    namespace = "dev.icerock.moko.permissions"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

