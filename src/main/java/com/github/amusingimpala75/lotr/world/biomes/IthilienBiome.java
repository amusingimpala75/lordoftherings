package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class IthilienBiome extends LotrBaseBiome {
    public IthilienBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.15F, 0.5F, 0.9F, 0.9F, -1, -1, -1, -1, 7710516);
    }

    @Override
    public String getName() {
        return "ithilien";
    }

    @Override
    public BlockState getTop() {
        return Blocks.GRASS_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Registry.BLOCK.get(id("gondor_rock")).getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Registry.BLOCK.get(id("gondor_rock")).getDefaultState();
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
