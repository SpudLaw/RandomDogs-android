// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.3.0" apply false
    id("org.jetbrains.kotlin.android") version libs.versions.kotlin.get() apply false
    kotlin("jvm") version libs.versions.kotlin.get()
    kotlin("plugin.serialization") version libs.versions.kotlin.get()
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
