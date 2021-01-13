package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

public class MirkwoodBiome extends LotrBaseBiome {
    public MirkwoodBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.2F, 0.4F, 0.6F, 0.8F, -1, 2774107, 3096365, 2841381, 3032091);
    }

    @Override
    protected int getWaterColor() {
        return 1708838;
    }

    @Override
    public String getName() {
        return "mirkwood";
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
}
