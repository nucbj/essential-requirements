plugins {
    // 루트 프로젝트의 기본 플러그인
    id("org.springframework.boot") version "3.3.4" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
}

allprojects {
    group = "io.task.estl.rqmt"

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    apply(plugin = "java")

    dependencies {
    }
}
