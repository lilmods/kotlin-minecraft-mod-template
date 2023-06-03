package com.example.modid.quilt

import net.examplemod.fabriclike.ExampleModFabricLike
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

object ModNameQuilt: ModInitializer {
    override fun onInitialize(mod: ModContainer?) {
        ExampleModFabricLike.init()
    }
}
