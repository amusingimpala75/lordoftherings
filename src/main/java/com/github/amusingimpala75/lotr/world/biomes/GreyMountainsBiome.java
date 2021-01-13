package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

public class GreyMountainsBiome extends LotrBaseBiome {
    public GreyMountainsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 1.8F, 2.0F, 0.28F, 0.3F, -1, -1, -1, -1, 13290689);
    }

    @Override
    protected int getSkyColor() {
        return 10862798;
    }

    @Override
    public String getName() {
        return "grey_mountains";
    }

    @Override
    public BlockState getTop() {
        return Blocks.SNOW_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Blocks.STONE.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.STONE.getDefaultState();
    }
}
