package dev.intelligentcreations.randore.common.world

import dev.intelligentcreations.randore.common.block.BlockInit.{deepslateRandomOre, endRandomOre, netherRandomOre, randomOre}
import dev.intelligentcreations.randore.common.config.OreGenConfig._
import net.minecraft.data.worldgen.features.OreFeatures.{DEEPSLATE_ORE_REPLACEABLES, NETHER_ORE_REPLACEABLES, STONE_ORE_REPLACEABLES}
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.placement.{BiomeFilter, CountPlacement, HeightRangePlacement, InSquarePlacement}
import net.minecraft.world.level.levelgen.structure.templatesystem.{RuleTest, TagMatchTest}
import net.minecraft.world.level.levelgen.{GenerationStep, VerticalAnchor}
import net.minecraftforge.common.Tags
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder
import net.minecraftforge.event.world.BiomeLoadingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

import java.util

@Mod.EventBusSubscriber
object OreGenerator {
  val END_STONE_ORE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES)
  @SubscribeEvent final def oreGeneration(event: BiomeLoadingEvent): Unit = {
    if (event.getCategory eq Biome.BiomeCategory.THEEND) {
      genOre(event.getGeneration, END_STONE_ORE_REPLACEABLES, endRandomOre.get().defaultBlockState(), END_R_SIZE.get(), END_R_MIN.get(), END_R_MAX.get(), END_R_VEIN.get())
    }
    else {
      if (event.getCategory eq Biome.BiomeCategory.NETHER) {
        genOre(event.getGeneration, NETHER_ORE_REPLACEABLES, netherRandomOre.get().defaultBlockState(), NETHER_R_SIZE.get(), NETHER_R_MIN.get(), NETHER_R_MAX.get(), NETHER_R_VEIN.get())
      }
      else {
        genOre(event.getGeneration, STONE_ORE_REPLACEABLES, randomOre.get().defaultBlockState(), COMMON_R_SIZE.get(), COMMON_R_MIN.get(), COMMON_R_MAX.get(), COMMON_R_VEIN.get())
        genOre(event.getGeneration, DEEPSLATE_ORE_REPLACEABLES, deepslateRandomOre.get().defaultBlockState(), DEEPSLATE_R_SIZE.get(), DEEPSLATE_R_MIN.get(), DEEPSLATE_R_MAX.get(), DEEPSLATE_R_VEIN.get())
      }
    }
  }

  private final def genOre(settings: BiomeGenerationSettingsBuilder, fillerType: RuleTest, state: BlockState, veinSize: Int, minHeight: Int, maxHeight: Int, maxperchunk: Int): Unit = {
    settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
      Feature.ORE.configured(new OreConfiguration(fillerType, state, veinSize)).
        placed(util.List.of(CountPlacement.of(UniformInt.of(0, maxperchunk)),
          InSquarePlacement.spread, HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight),
            VerticalAnchor.absolute(maxHeight)), BiomeFilter.biome)))
  }
}
