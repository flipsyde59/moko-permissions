/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.vanniktech).apply(false)
    alias(libs.plugins.compose).apply(false)
    alias(libs.plugins.native.cocoapods).apply(false)
    alias(libs.plugins.kotlinx.serialization).apply(false)
}
buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}
val mokoVersion = libs.versions.mokoPermissionsVersion.get()
allprojects {
    group = "io.github.flipsyde59"
    version = mokoVersion
}

tasks.register("clean", Delete::class).configure {
    delete(rootProject.buildDir)
}
