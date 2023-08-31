plugins {
    id("fabric-loom") version loomVersion
    kotlin("jvm")
    `maven-publish`
    java
}

base {
    archivesName.set(modId)
}

group = "$modGroup.fabric"
version = "$fabricModVersion-fabric"

repositories {
    maven("https://maven.shedaniel.me/") // cloth config
    maven("https://maven.terraformersmc.com/releases/") // mod menu
}

dependencies {
    compileOnly(project(":common"))
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnMappings:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc:fabric-language-kotlin:$fabricKotlinVersion")
    modApi("me.shedaniel.cloth:cloth-config-fabric:$clothConfigVersion") {
        exclude("net.fabricmc.fabric-api")
    }
    modApi("com.terraformersmc:modmenu:$modMenuVersion")
}

sourceSets {
    main {
        java {
            srcDir(project(":common").sourceSets.main.get().java)
        }

        kotlin {
            srcDir(project(":common").sourceSets.main.get().kotlin)
        }

        resources {
            srcDir(project(":common").sourceSets.main.get().resources)
        }
    }
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        from("LICENSE")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = jvmTarget
    }
}

java {
    withSourcesJar()
}
