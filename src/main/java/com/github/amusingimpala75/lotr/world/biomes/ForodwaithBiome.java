package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

public class ForodwaithBiome extends LotrBaseBiome {
    public ForodwaithBiome() {
        super(Biome.Precipitation.SNOW, Biome.Category.ICY, 0.1F, 0.1F, 0.0F, 0.2F, -1, -1, -1, -1, 14211282);
    }

    @Override
    protected int getSkyColor() {
        return 10069160;
    }

    @Override
    public String getName() {
        return "forodwaith";
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
