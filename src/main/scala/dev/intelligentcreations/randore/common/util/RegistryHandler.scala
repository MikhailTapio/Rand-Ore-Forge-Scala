package dev.intelligentcreations.randore.common.util

import dev.intelligentcreations.randore.common.RandOre
import dev.intelligentcreations.randore.common.block.BlockInit
import dev.intelligentcreations.randore.common.config.OreGenConfig
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.{DeferredRegister, ForgeRegistries}

object RegistryHandler {
  val Blocks: DeferredRegister[Block] = DeferredRegister.create(ForgeRegistries.BLOCKS, RandOre.MOD_ID)
  val Items: DeferredRegister[Item] = DeferredRegister.create(ForgeRegistries.ITEMS, RandOre.MOD_ID)
  val eventBus: IEventBus = FMLJavaModLoadingContext.get().getModEventBus
  def register(): Unit = {
    BlockInit.register()
    Blocks.register(eventBus)
    Items.register(eventBus)
    ModLoadingContext.get.registerConfig(ModConfig.Type.COMMON, OreGenConfig.COMMON_CONFIG)
  }
}
