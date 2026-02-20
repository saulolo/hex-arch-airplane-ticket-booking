plugins {
	java
	id("org.springframework.boot") version "4.0.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.airline"
version = "0.0.1-SNAPSHOT"
description = "RESTful API for airplane ticket booking system with Hexagonal Architecture, implementing flight search, reservation management, and ticket operations"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
    // ========== SPRING BOOT CORE ==========
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // ========== DATABASE ==========
    runtimeOnly("org.postgresql:postgresql")
    implementation("com.zaxxer:HikariCP")

    // ========== LOMBOK ==========
	compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // ========== DEV TOOLS ==========
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // ========== TESTING ==========
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<Jar>("jar") {
    enabled = false
}
