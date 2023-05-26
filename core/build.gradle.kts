plugins {
    kotlin("jvm")
}

group = "$modGroup.core"
version = coreVersion

repositories {
    mavenCentral()
}

dependencies {
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = jvmTarget
    }
}
