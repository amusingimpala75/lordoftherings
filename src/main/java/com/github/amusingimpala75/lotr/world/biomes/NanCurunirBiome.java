package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

public class NanCurunirBiome extends LotrBaseBiome {
    public NanCurunirBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.PLAINS, 0.2F, 0.1F, 0.6F, 0.4F, -1, -1, -1, -1, 7109714);
    }

    @Override
    protected int getSkyColor() {
        return 8683640;
    }

    @Override
    public String getName() {
        return "nan_curunir";
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
}
