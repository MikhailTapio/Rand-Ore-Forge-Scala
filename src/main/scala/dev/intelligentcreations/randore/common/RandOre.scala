package dev.intelligentcreations.randore.common

import dev.intelligentcreations.randore.common.util.RegistryHandler
import dev.intelligentcreations.randore.common.world.OreGenerator
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.{EventPriority, SubscribeEvent}
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.LogManager

@Mod(RandOre.MOD_ID)
object RandOre {
  final val MOD_ID = "randore"
  private val LOGGER = LogManager.getLogger

  RegistryHandler.register()
  MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGenerator.oreGeneration)
  MinecraftForge.EVENT_BUS.register(this)

  @SubscribeEvent
  def onServerStarting(event: ServerStartingEvent): Unit = {
    LOGGER.info("Thank u for downloading Randore(Scala)!")
  }
}
