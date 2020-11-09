package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class BrownLandsBiome extends LotrBaseBiome {
    public BrownLandsBiome() {
        super(Biome.Precipitation.NONE, Biome.Category.PLAINS, 0.2F, 0.2F, 0.8F, 0.2F, -1, -1, -1, 11373417, 8552016);
    }

    @Override
    public String getName() {
        return "brown_lands";
    }

    @Override
    public BlockState getTop() {
        return Blocks.COARSE_DIRT.getDefaultState();
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

    @Override
    protected int getSkyColor() {
        return 8878434;
    }
}
