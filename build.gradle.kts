val kotlinVersion: String by project // Make sure this is defined in gradle.properties

plugins {
    kotlin("jvm") version kotlinVersion // Must stay at 2.1.10 for Godot-Kotlin
    id("com.utopia-rise.godot-kotlin-jvm") version "0.12.1-4.4"
}

kotlin {
    jvmToolchain(22) // Specify the JDK version you want to use
}

repositories {
    mavenLocal()
    mavenCentral()
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
