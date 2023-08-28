plugins {
    kotlin("jvm")
}

group = "$modGroup.common"
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
