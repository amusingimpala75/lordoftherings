package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class RohanBiome extends LotrBaseBiome{
    public RohanBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.PLAINS, 0.2F, 0.15F, 0.8F, 0.8F, -1, -1, -1, -1, 7384389);
    }

    @Override
    public String getName() {
        return "rohan";
    }

    @Override
    public BlockState getTop() {
        return Blocks.GRASS_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Registry.BLOCK.get(id("rohan_rock")).getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.AIR.getDefaultState();
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
