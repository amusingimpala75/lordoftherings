package com.github.amusingimpala75.lotr.world.features;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModDefaultBiomeFeatures {
    public static void addDefaultOres(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_COPPER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_TIN);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_COAL);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_IRON);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_GOLD);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_SULFUR);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_NITER);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_SALT);
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, Features.ORE_SILVER);
    }

    public static void addAnimals(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 24, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PIG, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 20, 4, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 16, 4, 4));
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.BAT, 10, 8, 8));
    }
    public static void addShireGrass(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.SHIRE_GRASS);
    }
    public static void addPlainsFlowers(GenerationSettings.Builder builder) {
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.POPPY_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.DANDELION_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.AZURE_BLUET_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.OXEYE_DAISY_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.CORNFLOWER_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.RED_TULIP_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.WHITE_TULIP_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.ORANGE_TULIP_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.PINK_TULIP_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.BLUEBELL_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.LAVENDER_FEATURE);
        //builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.MARIGOLD_FEATURE);
    }
    public static void addDoubleFLowers(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.LILAC_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.ROSE_BUSH_FEATURE);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, Features.PEONY_FEATURE);
    }
    public static void addTrees(GenerationSettings.Builder builder, Object... trees) {
        for (Object tree : trees) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, (ConfiguredFeature<?, ?>) tree);
        }
    }

}
