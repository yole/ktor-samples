import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-content-negotiation:2.1.0")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:2.1.0")
    implementation("io.ktor:ktor-server-default-headers:2.1.0")
    implementation("io.ktor:ktor-server-auth:2.1.0")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    implementation("io.ktor:ktor-server-core-jvm:2.1.0")
    implementation("io.ktor:ktor-client-cio-jvm:2.1.0")
    implementation("io.ktor:ktor-client-logging-jvm:2.1.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}