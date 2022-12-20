plugins {
    id("ifood.kotlin-application-conventions")
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.spring") version "1.7.21"
}

dependencies {
    implementation(project(":commons"))
    implementation("org.slf4j:slf4j-simple")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework:spring-tx")
    implementation("javax.validation:validation-api")

}

application {
    // Define the main class for the application.
    mainClass.set("ifood.order-service.MainKt")
}
