package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static net.minecraft.block.Blocks.*;

public class ShireBiome extends LotrBaseBiome {
    public ShireBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.PLAINS, 0.15F, 0.3F, 0.8F, 0.7F, 329011, 12638463, -1, 8111137);
    }

    @Override
    public String getName() {
        return "shire";
    }

    @Override
    public BlockState getTop() {
        return GRASS_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return DIRT.getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return GRAVEL.getDefaultState();
    }

    @Override
    protected void addFeatures(GenerationSettings.Builder builder) {

    }

    @Override
    protected void addMobs(SpawnSettings.Builder builder) {

    }
}
