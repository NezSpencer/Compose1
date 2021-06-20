package com.nezspencer.compose1

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    object Compose {
        const val version = "1.0.0-beta08"
        private const val activityVersion = "1.3.0-beta02"
        const val animation = "androidx.compose.animation:animation:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val layout = "androidx.compose.foundation:foundation-layout:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val material = "androidx.compose.material:material:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiUtil = "androidx.compose.ui:ui-util:$version"
        const val activity = "androidx.activity:activity-compose:$activityVersion"
    }

    object Kotlin {
        private const val version = "1.5.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val embeddable = "org.jetbrains.kotlin:kotlin-compiler-embeddable:1.5.10"
    }

    object Coroutines {
        private const val version = "1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Tests {
        private const val junitVersion = "4.13"
        private const val mockitoVersion = "3.7.7"
        private const val androidTestVersion = "1.3.0"

        const val junit = "junit:junit:$junitVersion"
        const val mockitoCore = "org.mockito:mockito-core:$mockitoVersion"

        //UI/integration tests
        const val androidCore = "androidx.test:core:$androidTestVersion"
        const val junitAndroid = "androidx.test.ext:junit:1.1.2"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.version}"
        const val rules = "androidx.test:rules:$androidTestVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0-beta02"
        const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-alpha02"
        const val material = "com.google.android.material:material:1.3.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    val mainLibs = listOf(
        Compose.runtime,
        Compose.material,
        Compose.tooling,
        Compose.ui,
        Compose.activity,
        Coroutines.core,
        Coroutines.android,
        AndroidX.coreKtx,
        AndroidX.composeNavigation,
        AndroidX.material,
        Kotlin.stdlib,
        Kotlin.extensions,
        Kotlin.embeddable,
        AndroidX.appCompat,
        AndroidX.lifecycle
    )

    val testLibs = listOf(
        Tests.junit,
        Tests.mockitoCore
    )

    val androidTestLibs = listOf(
        Tests.junitAndroid,
        Tests.composeUiTest,
        Tests.espressoCore,
        Tests.rules,
        Tests.androidCore

    )
}

fun DependencyHandler.implementation(mainDependencies: List<String>){
    mainDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.kapt(kaptDependencies: List<String>) {
    kaptDependencies.forEach {
        add("kapt", it)
    }
}

fun DependencyHandler.testImplementation(testDependencies: List<String>) {
    testDependencies.forEach {
        add("testImplementation", it)
    }
}

fun DependencyHandler.androidTestImplementation(androidTestDependencies: List<String>){
    androidTestDependencies.forEach {
        add("androidTestImplementation", it)
    }
}