package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class LothlorienBiome extends LotrBaseBiome {
    public LothlorienBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.1F, 0.3F, 0.8F, 0.8F, -1, 16770660, -1, 11527451, 16504895);
    }

    @Override
    public String getName() {
        return "lothlorien";
    }

    @Override
    public BlockState getTop() {
        return Blocks.GRASS_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Blocks.STONE.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.STONE.getDefaultState();
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
