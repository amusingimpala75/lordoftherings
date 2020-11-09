package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class TrollshawsBiome extends LotrBaseBiome{
    public TrollshawsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.15F, 0.9F, 0.6F, 0.8F, -1, -1, -1, -1, 5798959);
    }

    @Override
    public String getName() {
        return "trollshaws";
    }

    @Override
    public BlockState getTop() {
        return Blocks.GRANITE.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Blocks.STONE.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.DIORITE.getDefaultState();
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
