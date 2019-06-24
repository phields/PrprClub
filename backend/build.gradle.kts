import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("plugin.jpa") version "1.2.71"
	id("org.springframework.boot") version "2.1.6.RELEASE"
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	kotlin("jvm") version "1.2.71"
	kotlin("plugin.spring") version "1.2.71"
}

group = "com.prprclub"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:5.9.0")

	implementation("org.mongodb", "mongodb-driver", "3.10.2") {
		isTransitive = false
	}
	implementation("org.mongodb", "mongodb-driver-core", "3.10.2")
	implementation("org.mongodb", "bson", "3.10.2")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb") {
		exclude("org.mongodb", "mongodb-driver")
	}

	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.security:spring-security-jwt:1.0.10.RELEASE")
	implementation("org.springframework.security.oauth:spring-security-oauth2:2.3.6.RELEASE")

	implementation("io.jsonwebtoken:jjwt:0.9.1")
	//implementation("org.springframework.boot:spring-security-crypto")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
