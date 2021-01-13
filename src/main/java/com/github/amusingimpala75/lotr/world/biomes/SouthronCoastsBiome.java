package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class SouthronCoastsBiome extends LotrBaseBiome {
    public SouthronCoastsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.PLAINS, 0.2F, 0.1F, 1.2F, 0.7F, -1, 16248281, -1, 11914805, 10398286);
    }

    @Override
    public String getName() {
        return "southron_coasts";
    }

    @Override
    public BlockState getTop() {
        return Blocks.SAND.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Blocks.COARSE_DIRT.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.RED_SAND.getDefaultState();
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
