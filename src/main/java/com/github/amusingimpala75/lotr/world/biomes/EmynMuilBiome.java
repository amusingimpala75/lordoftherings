package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class EmynMuilBiome extends LotrBaseBiome {
    public EmynMuilBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.DESERT, 0.2F, 0.8F, 0.5F, 0.9F, -1, -1, -1, 9539937, 9866354);
    }

    @Override
    protected int getSkyColor() {
        return 10000788;
    }

    @Override
    public String getName() {
        return "emyn_muil";
    }

    @Override
    public BlockState getTop() {
        return Blocks.STONE.getDefaultState();
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
