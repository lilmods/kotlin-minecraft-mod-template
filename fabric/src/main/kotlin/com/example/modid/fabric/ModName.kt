package com.example.modid.fabric

import com.example.modid.fabric.config.ModConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.fabricmc.api.ModInitializer

class ModName : ModInitializer {
    override fun onInitialize() {
        AutoConfig.register(ModConfig::class.java, ::JanksonConfigSerializer)
        val config = AutoConfig.getConfigHolder(ModConfig::class.java).config
        println("Hello world, config: $config")
    }
}
