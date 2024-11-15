import com.vanniktech.maven.publish.SonatypeHost

/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.vanniktech)
    alias(libs.plugins.compose)
}
kotlin {
    androidTarget()
    jvm("desktop")
    applyDefaultHierarchyTemplate()
    iosSimulatorArm64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":permissions"))
                api(compose.runtime)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.activity)
                implementation(libs.composeUi)
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
mavenPublishing {
    coordinates(
        groupId = group.toString(),
        artifactId = "moko.permissions.compose",
        version = version.toString()
    )
    pom {
        name.set("moko-permissions with desktop sourceSet")
        description.set("Library for moko-permission with source set jvm('desktop')")
        inceptionYear.set("2024")
        url.set("https://github.com/flipsyde59/moko-permissions")

        licenses {
            license {
                name.set("Apache")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }

        // Specify developer information
        developers {
            developer {
                id.set("flipsyde59")
                email.set("flipsyde59@yandex.ru")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/flipsyde59/moko-permissions")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}
android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    kotlin {
        jvmToolchain(17)
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
    namespace = "dev.icerock.moko.permissions.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = 21
    }
}

