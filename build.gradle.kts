plugins {
    id("java")
    id("io.qameta.allure") version "3.0.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.12")
    implementation("org.slf4j:slf4j-simple:2.0.12")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testImplementation("com.codeborne:selenide:7.14.0")
    testImplementation("io.qameta.allure:allure-selenide:2.32.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:6.3.3")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.test {
    useJUnitPlatform()
}

allure {
    report {
        version.set("2.32.0") //версия Allure Report (https://github.com/allure-framework/allure2)
    }
    adapter {
        aspectjWeaver.set(true) // обработка аннотации @Step
        frameworks {
            junit5 {
                adapterVersion.set("2.32.0") //версия Allure JUnit5 (https://github.com/allure-framework/allure-java)
            }
        }
    }
}