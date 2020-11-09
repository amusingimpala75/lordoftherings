package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class RiverBiome extends LotrBaseBiome{
    public RiverBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.RIVER, -0.75F, 0.0F, 0.5F, 0.5F, -1, -1, -1, -1, 3570869);
    }

    @Override
    public String getName() {
        return "river";
    }

    @Override
    public BlockState getTop() {
        return Blocks.DIRT.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Blocks.STONE.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.GRAVEL.getDefaultState();
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
