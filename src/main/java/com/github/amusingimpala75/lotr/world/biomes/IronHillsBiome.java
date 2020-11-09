package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class IronHillsBiome extends LotrBaseBiome {
    public IronHillsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 0.3F, 1.4F, 0.27F, 0.4F, -1, -1, -1, -1, 9142093);
    }

    @Override
    public String getName() {
        return "iron_hills";
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
