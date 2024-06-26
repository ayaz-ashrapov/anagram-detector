plugins {
    kotlin("jvm") version "2.0.0"
    application
}

group = "com.ashrapov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.9.3")
}

application {
    mainClass = "com.ashrapov.MainKt"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}