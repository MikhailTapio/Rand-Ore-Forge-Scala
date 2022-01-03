package dev.intelligentcreations.randore.common.block

import dev.intelligentcreations.randore.common.util.RegistryHandler
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.{BlockItem, CreativeModeTab}
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.{Block, OreBlock, SoundType}
import net.minecraft.world.level.material.Material
import net.minecraftforge.registries.RegistryObject

object BlockInit {
  //names
  val COMMON = "random_ore"
  val DEEPSLATE = "deepslate_random_ore"
  val NETHER = "nether_random_ore"
  val END = "end_random_ore"
  var randomOre: RegistryObject[Block] = _
  var deepslateRandomOre: RegistryObject[Block] = _
  var netherRandomOre: RegistryObject[Block] = _
  var endRandomOre: RegistryObject[Block] = _

  //blocks
  final def register(): Unit = {
    randomOre = initOreBlock(COMMON, SoundType.STONE, 4)
    deepslateRandomOre = initOreBlock(DEEPSLATE, SoundType.DEEPSLATE, 6)
    netherRandomOre = initOreBlock(NETHER, SoundType.NETHER_ORE, 3)
    endRandomOre = initOreBlock(END, SoundType.STONE, 5)
    //blockItems
    val iCommon = initOreBlockItem(COMMON, randomOre)
    val iDeepslate = initOreBlockItem(DEEPSLATE, deepslateRandomOre)
    val iNether = initOreBlockItem(NETHER, netherRandomOre)
    val iEnd = initOreBlockItem(END, endRandomOre)
  }
  final def initOreBlock(name:String, soundType: SoundType, strength:Int): RegistryObject[Block] = {
    RegistryHandler.Blocks.register(name,
      () => new OreBlock(BlockBehaviour.Properties
        .of(Material.STONE)
        .sound(soundType)
        .strength(strength)
        .requiresCorrectToolForDrops()))
  }

  final def initOreBlockItem(name:String, block: RegistryObject[Block]): RegistryObject[BlockItem] = {
    RegistryHandler.Items.register(name,
      () => new BlockItem(block.get(), new Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)))
  }
}
