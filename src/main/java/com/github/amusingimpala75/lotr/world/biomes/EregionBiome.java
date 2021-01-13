package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;

public class EregionBiome extends LotrBaseBiome {
    public EregionBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.2F, 0.3F, 0.7F, 0.7F, -1, -1, -1, -1, 6656072);
    }

    @Override
    public String getName() {
        return "eregion";
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
