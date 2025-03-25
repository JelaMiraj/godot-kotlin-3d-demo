// val kotlinVersion: String by project // Make sure this is defined in gradle.properties

buildscript {
    val kotlinVersion = project.property("kotlin.version")
}

plugins {
    kotlin("jvm") version System.getProperty("kotlin.version", "2.1.10")
    id("com.utopia-rise.godot-kotlin-jvm") version "0.12.1-4.4"
}

kotlin {
    jvmToolchain(22) // Specify the JDK version you want to use
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    // Kotlin BOM from JetBrains
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
}

godot {
    registrationFileBaseDir.set(projectDir.resolve("scripts"))
    isRegistrationFileHierarchyEnabled.set(true)

    isGodotCoroutinesEnabled.set(true)
}

kotlin.sourceSets.main {
    kotlin.srcDirs("demo")
}
