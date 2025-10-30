import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "2.2.20"
}

group = "com.nfvzhn"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
}

val junitVersion = "6.0.0"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
    testLogging { events = setOf(PASSED, SKIPPED, FAILED) }
}

kotlin {
    jvmToolchain(24)
}