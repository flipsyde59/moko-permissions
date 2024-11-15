/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.native.cocoapods)
}
kotlin {
    androidTarget()
    jvm("desktop")
    applyDefaultHierarchyTemplate()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                api(libs.mokoMvvmCore)
                api(project(":permissions"))
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
                implementation(project(":permissions-test"))
            }
        }
    }
    cocoapods {
        version = "0.10.0"
        summary = "Some summary for test"
        homepage = "Link to homepage"
        framework {
            baseName = "MppLibrary"
            export(project(":permissions"))
            export(libs.mokoMvvmCore)
        }
    }
}
android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    namespace = "com.icerockdev.library"
}

