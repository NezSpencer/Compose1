import com.nezspencer.compose1.Dependencies
import com.nezspencer.compose1.androidTestImplementation
import com.nezspencer.compose1.implementation
import com.nezspencer.compose1.testImplementation
import com.nezspencer.compose1.kapt

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.nezspencer.compose1"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            this.isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.version
    }

    packagingOptions {
        this.resources.excludes.add("META-INF/licenses/**")
        this.resources.excludes.add("META-INF/AL2.0")
        this.resources.excludes.add("META-INF/LGPL2.1")
    }
}

dependencies {
    implementation(Dependencies.mainLibs)
    testImplementation(Dependencies.testLibs)
    androidTestImplementation(Dependencies.androidTestLibs)
    kapt(Dependencies.kspLibs)
}