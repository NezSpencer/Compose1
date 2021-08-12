package com.nezspencer.compose1

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {

    object Compose {
        const val version = "1.0.0-beta09"
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

    object Accompanist {
        const val version = "0.11.0"
        const val coil = "com.google.accompanist:accompanist-coil:$version"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val paging = "com.google.accompanist:accompanist-pager:$version"
    }

    object Kotlin {
        private const val version = "1.5.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Coroutines {
        private const val version = "1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val kotlinxAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Tests {
        private const val junitVersion = "4.13"
        private const val mockitoVersion = "3.7.7"
        private const val androidTestVersion = "1.3.0"

        const val junit = "junit:junit:$junitVersion"
        const val mockitoCore = "org.mockito:mockito-core:$mockitoVersion"
        const val roomTestHelper = "androidx.room:room-testing:${AndroidX.roomVersion}"

        //UI/integration tests
        const val androidCore = "androidx.test:core:$androidTestVersion"
        const val junitAndroid = "androidx.test.ext:junit:1.1.2"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Compose.version}"
        const val rules = "androidx.test:rules:$androidTestVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object AndroidX {
        const val roomVersion = "2.3.0"
        const val hiltVersion = "2.38.1"
        const val coreKtx = "androidx.core:core-ktx:1.6.0-beta02"
        const val composeNavigation = "androidx.navigation:navigation-compose:2.4.0-alpha03"
        const val material = "com.google.android.material:material:1.3.0"
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
        const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val roomKtx = "androidx.room:room-ktx:$roomVersion"
        const val roomKsp = "androidx.room:room-compiler:$roomVersion"

        const val hiltClassPath = "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltKsp = "com.google.dagger:hilt-android-compiler:$hiltVersion"

        const val sqlJdbcKapt = "org.xerial:sqlite-jdbc:3.34.0"
    }

    val mainLibs = listOf(
        Compose.runtime,
        Compose.material,
        Compose.tooling,
        Compose.ui,
        Compose.activity,
        Coroutines.core,
        Coroutines.kotlinxAndroid,
        AndroidX.coreKtx,
        AndroidX.composeNavigation,
        AndroidX.material,
        Kotlin.stdlib,
        AndroidX.appCompat,
        AndroidX.lifecycle,
        Accompanist.insets,
        Accompanist.paging,
        AndroidX.roomRuntime,
        AndroidX.roomKtx
    )

    val testLibs = listOf(
        Tests.junit,
        Tests.mockitoCore,
        Tests.roomTestHelper
    )

    val androidTestLibs = listOf(
        Tests.junitAndroid,
        Tests.composeUiTest,
        Tests.espressoCore,
        Tests.rules,
        Tests.androidCore

    )

    val kspLibs = listOf(
        AndroidX.roomKsp,
        AndroidX.sqlJdbcKapt
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