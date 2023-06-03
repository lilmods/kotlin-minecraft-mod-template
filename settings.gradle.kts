rootProject.name = "ModName"

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        gradlePluginPortal()
    }
}

include("common")
include("fabric-like")
include("fabric")
include("quilt")
include("forge")
