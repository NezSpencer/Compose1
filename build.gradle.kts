// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha02")
        classpath(com.nezspencer.compose1.Dependencies.Kotlin.gradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        if (com.nezspencer.compose1.Dependencies.Accompanist.version.endsWith("SNAPSHOT")) {
            maven {
                this.artifactUrls("https://oss.sonatype.org/content/repositories/snapshots/")
            }
        }

    }
}

tasks.register("clean").configure{
    delete("build")
}