// Common
const val kotlinVersion = "1.9.10"
const val jvmTarget = "17"

// Minecraft
const val minecraftVersion = "1.20.1"

// Mod
const val modId = "modid"
const val modGroup = "com.example.$modId"
const val coreVersion = "1.0.0"

// Forge - also update mods.toml
const val kotlinForForge = "4.3.0" // https://github.com/thedarkcolour/KotlinForForge
const val kotlinGradlePlugin = kotlinVersion
const val forgeVersion = "47.1.0" // https://files.minecraftforge.net/net/minecraftforge/forge
const val forgeGradlePlugin = "[6.0,6.2)" // https://files.minecraftforge.net/net/minecraftforge/gradle/ForgeGradle/
const val forgeModVersion = "1.0.0-MC$minecraftVersion"
const val forgeModArchive = "$modId-$forgeModVersion-forge"

// Fabric - also update fabric.mod.json
// 1.2+ requires gradle 8, forge is not yet compatible
const val loomVersion = "1.3-SNAPSHOT" // https://github.com/FabricMC/fabric-example-mod
const val yarnMappings = "$minecraftVersion+build.9" // https://fabricmc.net/develop/
const val loaderVersion = "0.14.21" // https://fabricmc.net/develop/
const val fabricModVersion = "1.0.0-MC$minecraftVersion"
const val fabricModArchive = "$modId-$fabricModVersion-fabric"

// External dependencies

// Common
const val clothConfigVersion = "11.1.106" // https://linkie.shedaniel.dev/dependencies

// Fabric - also update fabric.mod.json
const val fabricKotlinVersion = "1.10.10+kotlin.$kotlinVersion" // https://github.com/FabricMC/fabric-language-kotlin
const val modMenuVersion = "7.2.1" // https://github.com/TerraformersMC/ModMenu/releases

// Forge
