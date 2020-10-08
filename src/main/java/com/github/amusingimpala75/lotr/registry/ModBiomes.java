package com.github.amusingimpala75.lotr.registry;

import com.github.amusingimpala75.lotr.world.features.Features;
import com.github.amusingimpala75.lotr.world.features.ModDefaultBiomeFeatures;
import net.fabricmc.fabric.mixin.biome.BuiltinBiomesAccessor;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModBiomes {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SHIRE_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
            Blocks.GRASS_BLOCK.getDefaultState(),
            Blocks.DIRT.getDefaultState(),
            Blocks.SAND.getDefaultState()));
    private static final Biome SHIRE = createShire();
    private static Biome createShire() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        ModDefaultBiomeFeatures.addAnimals(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(SHIRE_SURFACE_BUILDER);
        ModDefaultBiomeFeatures.addDefaultOres(generationSettings);
        ModDefaultBiomeFeatures.addShireGrass(generationSettings);
        ModDefaultBiomeFeatures.addPlainsFlowers(generationSettings);
        ModDefaultBiomeFeatures.addDoubleFLowers(generationSettings);
        ModDefaultBiomeFeatures.addTrees(generationSettings, Features.ASPEN_TREE/*Features.OAK_TREE, Features.FANCY_OAK, Features.FANCY_OAK_BEES, Features.OAK_BEES, Features.BIRCH_TREE, Features.FANCY_BIRCH, Features.FANCY_BIRCH_BEES, Features.BIRCH_BEES, */);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.PLAINS)
                .depth(0.15F)
                .scale(0.3F)
                .temperature(0.8F)
                .downfall(0.7F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x329011)
                        .skyColor(0x888888)
                        .fogColor(12638463)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }
    public static final RegistryKey<Biome> SHIRE_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("lotr", "shire"));


    public static void registerBiomes() {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("lotr", "shire"), SHIRE_SURFACE_BUILDER);

        Registry.register(BuiltinRegistries.BIOME, SHIRE_KEY.getValue(), SHIRE);
        BuiltinBiomesAccessor.getBY_RAW_ID().put(BuiltinRegistries.BIOME.getRawId(SHIRE), SHIRE_KEY);
    }
}
