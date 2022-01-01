package dev.intelligentcreations.randore.common.config

import net.minecraftforge.common.ForgeConfigSpec

object OreGenConfig {
  //Main
  val COMMON_BUILDER = new ForgeConfigSpec.Builder()
  val W = "What value should be these ores' "
  val C = "common_randore_"
  val D = "deepslate_randore_"
  val E = "end_randore_"
  val N = "nether_randore_"
  val S = "size"
  val I = "min_y"
  val X = "max_y"
  val P = "vein_per_chunk"
  //Vein Size Configuration
  val COMMON_R_SIZE: ForgeConfigSpec.IntValue =
    COMMON_BUILDER.comment(W + "maximum vein size?")
      .defineInRange(C + S, 3, 0, 16)
  val DEEPSLATE_R_SIZE: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(D + S, 4, 0, 16)
  val END_R_SIZE: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(E + S, 7, 0, 16)
  val NETHER_R_SIZE: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(N + S, 5, 0, 16)

  //Min Y Configuration
  val COMMON_R_MIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER.comment(W + "minimum generation height?")
      .defineInRange(C + I, 16, -64, 320)
  val DEEPSLATE_R_MIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(D + I, -64, -64, 320)
  val END_R_MIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(E + I, 10, 0, 256)
  val NETHER_R_MIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(N + I, 1, 1, 256)

  //Max Y Configuration
  val COMMON_R_MAX: ForgeConfigSpec.IntValue =
    COMMON_BUILDER.comment(W + "maximum generation height?")
      .defineInRange(C + X, 128, -64, 320)
  val DEEPSLATE_R_MAX: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(D + X, 16, -64, 320)
  val END_R_MAX: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(E + X, 256, 0, 256)
  val NETHER_R_MAX: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(N + X, 256, 1, 256)

  //Vein Per Chunk Configuration
  val COMMON_R_VEIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER.comment(W + "maximum vein size?")
      .defineInRange(C + P, 13, 0, 16)
  val DEEPSLATE_R_VEIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(D + P, 8, 0, 16)
  val END_R_VEIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(E + P, 10, 0, 16)
  val NETHER_R_VEIN: ForgeConfigSpec.IntValue =
    COMMON_BUILDER
      .defineInRange(N + P, 10, 0, 16)

  val COMMON_CONFIG: ForgeConfigSpec = COMMON_BUILDER.build()

}
