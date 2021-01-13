package com.github.amusingimpala75.lotr.world;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;

public class MEGenSettings extends ChunkGeneratorSettings {
    public MEGenSettings(GenerationShapeConfig shapeConfig) {
        super(new StructuresConfig(false), shapeConfig, Blocks.GRASS_BLOCK.getDefaultState(), Blocks.WATER.getDefaultState(), 0, 0, 63, false);
    }

    public int getClassicBiomeSize() {
        return 5;
    }

    public int getRiverSize() {
        return 6;
    }

    public int getSingleWorldBiomeId() {
        return -1;
    }

    public int getBedrockFloorHeight() {
        return 0;
    }
}
