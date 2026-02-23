plugins {
	java
	id("org.springframework.boot") version "4.0.3"
	id("io.spring.dependency-management") version "1.1.7"
    id("jacoco")
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

jacoco {
    toolVersion = "0.8.11"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}


tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(true)
    }
    finalizedBy(tasks.jacocoTestCoverageVerification)

    classDirectories.setFrom(
        files(
            classDirectories.files.map {
                fileTree(it) {
                    exclude(
                        // === Paquetes/capetas a excluir ===
                        "**/infrastructure/adapter/in/rest/handler/**",
                        "**/infrastructure/adapter/in/rest/controller/dto/response/**",
                        "**/infrastructure/adapter/out/persistence/jpa/mapper/**",
                        "**/exception/**",
                        "**/domain/enums/**",
                        "**/infrastructure/adapter/in/rest/mapper/**",
                        "**/domain/exception/**",
                        "**/infrastructure/adapter/in/rest/controller/**",
                        "**/infrastructure/adapter/out/persistence/jpa/**",
                        "**/infrastructure/util/**",
                        "**/infrastructure/config/**",
                        "**/domain/dto/**",
                        "**/HexArchAirplaneTicketBookingApplication*"
                    )
                }
            }
        )
    )
}

tasks.jacocoTestCoverageVerification {
    dependsOn(tasks.test)
    classDirectories.setFrom(
        files(
            tasks.jacocoTestReport.get().classDirectories.files.map {
                fileTree(it) {
                    exclude(
                        "**/infrastructure/adapter/in/rest/handler/**",
                        "**/infrastructure/adapter/in/rest/controller/dto/response/**",
                        "**/infrastructure/adapter/out/persistence/jpa/mapper/**",
                        "**/exception/**",
                        "**/domain/enums/**",
                        "**/infrastructure/adapter/in/rest/mapper/**",
                        "**/domain/exception/**",
                        "**/infrastructure/adapter/in/rest/controller/**",
                        "**/infrastructure/adapter/out/persistence/jpa/**",
                        "**/infrastructure/util/**",
                        "**/infrastructure/config/**",
                        "**/domain/dto/**",
                        "**/HexArchAirplaneTicketBookingApplication*"
                    )
                }
            }
        )
    )
    violationRules {
        rule {
            element = "BUNDLE"
            limit {
                counter = "LINE"
                value = "COVEREDRATIO"
                minimum = "0.50".toBigDecimal()
            }
        }
    }
}

