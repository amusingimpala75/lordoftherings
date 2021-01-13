package com.github.amusingimpala75.lotr.world.biomes;

import com.github.amusingimpala75.lotr.world.features.ModDefaultBiomeFeatures;
import com.github.amusingimpala75.lotr.world.features.TreeCluster;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static net.minecraft.block.Blocks.*;
/*
Biome of the Shire
 */
public class ShireBiome extends LotrBaseBiome {
    public ShireBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.PLAINS, 0.15F, 0.3F, 0.8F, 0.7F, 329011, 12638463, -1, 8111137,6794549);
    }
    protected ShireBiome(Biome.Precipitation precipType, Biome.Category category, float depth, float scale, float temp, float downfall, int waterFogColor, int fogColor, int foliageColor, int mapColor) {
        super(precipType, category, depth, scale, temp, downfall, waterFogColor, fogColor, foliageColor, 8111137, mapColor);
    }

    @Override
    public String getName() {
        return "shire";
    }

    @Override
    public BlockState getTop() {
        return GRASS_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return DIRT.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return GRAVEL.getDefaultState();
    }

    @Override
    protected void addFeatures(GenerationSettings.Builder builder) {
        super.addFeatures(builder);
    }

    @Override
    protected void addMobs(SpawnSettings.Builder builder) {
        super.addMobs(builder);
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 5, 2, 4));
    }
    protected void addStoneVariants(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addCommonGranite(builder);
    }

    protected final Object[] shireTrees() {
        return new Object[]{ModDefaultBiomeFeatures.oak(), 10000, ModDefaultBiomeFeatures.oakFancy(), 4000, ModDefaultBiomeFeatures.oakBees(), 100, ModDefaultBiomeFeatures.oakFancyBees(), 40, ModDefaultBiomeFeatures.birch(), 250, ModDefaultBiomeFeatures.birchFancy(), 100, ModDefaultBiomeFeatures.birchBees(), 2, ModDefaultBiomeFeatures.birchFancyBees(), 1, ModDefaultBiomeFeatures.aspen(), 500, ModDefaultBiomeFeatures.aspenLarge(), 100, ModDefaultBiomeFeatures.apple(), 50, ModDefaultBiomeFeatures.appleBees(), 1, ModDefaultBiomeFeatures.pear(), 50, ModDefaultBiomeFeatures.pearBees(), 1, ModDefaultBiomeFeatures.cherry(), 20, ModDefaultBiomeFeatures.cherryBees(), 1};
    }

    protected void addVegetation(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addTreesWithClusters(builder, 0, 0.2F, TreeCluster.of(10, 6), this,  this.shireTrees());
        ModDefaultBiomeFeatures.addShireGrass(builder, this,  8);
        ModDefaultBiomeFeatures.addPlainsFlowers(builder, this, 3, new Object[0]);
        ModDefaultBiomeFeatures.addDefaultDoubleFlowers(builder, this, 1, new Object[0]);
        ModDefaultBiomeFeatures.addSunflowers(builder, this, 6);
        ModDefaultBiomeFeatures.addWildPipeweedChance(builder, 6);
    }

    protected void addLiquidSprings(GenerationSettings.Builder builder) {
        ModDefaultBiomeFeatures.addWaterSprings(builder);
    }
}
