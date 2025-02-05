import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

private val ktor_version: String by project
private val logback_version: String by project
plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.0"
    id("com.gradleup.shadow") version "9.0.0-beta7"
    `maven-publish`
}

group = "com.dergruenkohl"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    testImplementation(kotlin("test"))
}
tasks.withType<ShadowJar> {
    mergeServiceFiles()
    archiveFileName = "Hypixel-Kotlin.jar"
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            artifact(tasks["shadowJar"])
        }
    }
}



tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}