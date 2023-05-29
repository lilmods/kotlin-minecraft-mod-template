package com.example.modid.forge

import com.example.modid.forge.config.ModConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod

@Mod("modid")
class ModName {
    init {
        // Init config screen
        AutoConfig.register(ModConfig::class.java, ::JanksonConfigSerializer)
        ModLoadingContext
            .get()
            .registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory::class.java) {
                ConfigScreenHandler.ConfigScreenFactory { _: Minecraft?, parent: Screen? ->
                    AutoConfig.getConfigScreen(
                        ModConfig::class.java,
                        parent,
                    ).get()
                }
            }

        // Use config
        val config = AutoConfig.getConfigHolder(ModConfig::class.java).config
        println("Hello world, $config")
    }
}
