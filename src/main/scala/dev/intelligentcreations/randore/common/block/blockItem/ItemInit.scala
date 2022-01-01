package dev.intelligentcreations.randore.common.block.blockItem

import dev.intelligentcreations.randore.common.block.BlockInit._
import net.minecraft.world.item.BlockItem
import net.minecraftforge.registries.RegistryObject

object ItemInit {
  //blockItems
  var iCommon: RegistryObject[BlockItem] = _
  var iDeepslate: RegistryObject[BlockItem] = _
  var iNether: RegistryObject[BlockItem] = _
  var iEnd: RegistryObject[BlockItem] = _

  //blockItems
  final def register(): Unit = {
    iCommon = initOreBlockItem(COMMON, randomOre)
    iDeepslate = initOreBlockItem(DEEPSLATE, deepslateRandomOre)
    iNether = initOreBlockItem(NETHER, netherRandomOre)
    iEnd = initOreBlockItem(END, endRandomOre)
  }
}
