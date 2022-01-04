package dev.intelligentcreations.randore.common

import dev.intelligentcreations.randore.common.util.RegistryHandler
import dev.intelligentcreations.randore.common.world.OreGenerator
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.EventPriority
import net.minecraftforge.fml.common.Mod

@Mod(RandOre.MOD_ID)
object RandOre {
  final val MOD_ID = "randore"

  RegistryHandler.register()
  MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGenerator.oreGeneration)
  MinecraftForge.EVENT_BUS.register(this)
}
