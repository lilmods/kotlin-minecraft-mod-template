package com.example.modid.forge

import com.example.modid.forge.config.ModConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.minecraftforge.fml.common.Mod

@Mod("modid")
class ModName {
    init {
        // TODO: fix: screen is not accessible from forge mod menu
        AutoConfig.register(ModConfig::class.java, ::JanksonConfigSerializer)
        val config = AutoConfig.getConfigHolder(ModConfig::class.java).config

        // TODO: finish this
//        ModLoadingContext
//            .get()
//            .registerExtensionPoint(
//                ConfigScreenFactory::class.java,
//                () -> (client, parent) -> AutoConfig.getConfigScreen(ModConfig::class.java, parent).get()
//            )

        println("Hello world, $config")
    }
}
