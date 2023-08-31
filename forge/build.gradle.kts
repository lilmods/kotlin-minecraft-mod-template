
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.js.backend.ast.JsEmpty
import java.text.SimpleDateFormat
import java.util.Date

buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinGradlePlugin")
    }
}

plugins {
    kotlin("jvm")
    id("net.minecraftforge.gradle") version forgeGradlePlugin
}

group = "$modGroup.forge"
version = "$forgeModVersion-forge"

repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge/") // Kotlin for Forge
    maven("https://maven.shedaniel.me/") // Cloth config
}

dependencies {
    minecraft("net.minecraftforge:forge:$minecraftVersion-$forgeVersion")
    implementation("thedarkcolour:kotlinforforge:$kotlinForForge")
    api(fg.deobf("me.shedaniel.cloth:cloth-config-forge:$clothConfigVersion"))
    compileOnly(project(":common"))
}

val Project.minecraft: net.minecraftforge.gradle.common.util.MinecraftExtension
    get() = extensions.getByType()

minecraft.let {
    it.mappings("official", minecraftVersion)
    it.runs {
        create("client") {
            workingDirectory(project.file("run"))
            property("forge.logging.console.level", "debug")
            mods {
                create(modId) {
                    sources(
                        sourceSets.main.get(),
                        project(":common").sourceSets.main.get(),
                    )
                }
            }
        }
    }
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
    val javaVersion = JavaVersion.valueOf("VERSION_$jvmTarget")
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = javaVersion.toString()
        targetCompatibility = javaVersion.toString()
        if (JavaVersion.current().isJava9Compatible) {
            options.release.set(javaVersion.toString().toInt())
        }
    }

    withType<ProcessResources> {
        from(project(":common").sourceSets.main.get().resources)
    }

    withType<KotlinCompilationTask<*>> {
        configureEach {
            JsEmpty.source(project(":common").sourceSets.main.get().allSource)
        }
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = javaVersion.toString()
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaVersion.toString()))
        }
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        archiveBaseName.set(modId)
        manifest {
            attributes(
                mapOf(
                    "Implementation-Title" to project.name,
                    "Implementation-Version" to project.version,
                    "Implementation-Timestamp" to SimpleDateFormat("yyyy-MM-dd").format(Date()),
                ),
            )
        }
        finalizedBy("reobfJar")
    }
}
