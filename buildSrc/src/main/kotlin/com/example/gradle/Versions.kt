// Common
const val kotlinVersion = "1.8.21"
const val jvmTarget = "17"

// Minecraft
const val minecraftVersion = "1.19.4"

// Mod
const val modId = "modid"
const val modGroup = "com.example.$modId"
const val coreVersion = "1.0.0"

// Forge - also update mods.toml
const val kotlinForForge = "4.2.0" // https://github.com/thedarkcolour/KotlinForForge
const val kotlinGradlePlugin = kotlinVersion
const val forgeVersion = "45.0.59" // https://files.minecraftforge.net/net/minecraftforge/forge
const val forgeGradlePlugin = "6.0.+" // https://files.minecraftforge.net/net/minecraftforge/gradle/ForgeGradle/
const val forgeModVersion = "1.0.0-MC$minecraftVersion"

// Fabric - also update fabric.mod.json
// 1.2+ requires gradle 8, forge is not yet compatible
const val loomVersion = "1.2-SNAPSHOT" // https://github.com/FabricMC/fabric-example-mod
const val yarnMappings = "$minecraftVersion+build.2" // https://fabricmc.net/develop/
const val loaderVersion = "0.14.19" // https://fabricmc.net/develop/
const val fabricModVersion = "1.0.0-MC$minecraftVersion"

// External dependencies

// Common
const val clothConfigVersion = "10.0.96" // https://linkie.shedaniel.dev/dependencies

// Fabric - also update fabric.mod.json
const val fabricKotlinVersion = "1.9.4+kotlin.$kotlinVersion" // https://github.com/FabricMC/fabric-language-kotlin
const val modMenuVersion = "6.2.2" // https://github.com/TerraformersMC/ModMenu/releases

// Forge
