package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
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
    }
}
