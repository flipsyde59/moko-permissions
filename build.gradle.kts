/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */
plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.android.application).apply(false)
}
buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.kotlinGradlePlugin)
        classpath(libs.androidGradlePlugin)
        classpath(libs.mokoGradlePlugin)
        classpath(libs.kotlinSerializationGradlePlugin)
        classpath(libs.composeJetBrainsGradlePlugin)
        classpath(libs.detektGradlePlugin)
    }
}
val mokoVersion = libs.versions.mokoPermissionsVersion.get()
allprojects {
    group = "flipsyde59.moko"
    version = mokoVersion
}

tasks.register("clean", Delete::class).configure {
    delete(rootProject.buildDir)
}
