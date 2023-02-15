plugins {
    kotlin("jvm") version "1.8.0"
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "1.1.0"
    id("fr.brouillard.oss.gradle.jgitver") version "0.10.0-rc03"
}

group = "com.faendir.gradle"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")
    implementation("net.pearx.kasechange:kasechange:1.3.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins {
        create("BomVersionCatalogPlugin") {
            id = "com.faendir.gradle.bom-version-catalog"
            displayName = "Bom to version catalog plugin"
            description = "Allows to import boms as version catalogs"
            implementationClass = "com.faendir.gradle.BomVersionCatalogPlugin"
        }
    }
}

gradlePlugin {
    website.set("https://github.com/F43nd1r/bomVersionCatalog")
    vcsUrl.set("https://github.com/F43nd1r/bomVersionCatalog")
}



project.configurations.detachedConfiguration()
