package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class MordorBiome extends LotrBaseBiome{
    public MordorBiome() {
        super(Biome.Precipitation.NONE, Biome.Category.DESERT, 0.3F, 0.5F, 1.5F, 0.0F, 2498845, 3154711, 6508333, 5980459, 1118222);
    }

    @Override
    protected int getWaterColor() {
        return super.getWaterColor();
    }

    @Override
    protected int getSkyColor() {
        return 6700595;
    }

    @Override
    public String getName() {
        return "mordor";
    }

    @Override
    public BlockState getTop() {
        return Registry.BLOCK.get(id("mordor_rock")).getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Registry.BLOCK.get(id("mordor_rock")).getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Registry.BLOCK.get(id("mordor_gravel")).getDefaultState();
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
