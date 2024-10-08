import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "io.task.estl.rqmt"
version = "0.0.1"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.1.4")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<Jar> {
    archiveBaseName.set("corekit")
    archiveVersion.set(version.toString())
}

tasks.withType<BootJar> {
    enabled = false
}

