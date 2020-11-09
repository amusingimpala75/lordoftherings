package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class BlueMountainsBiome extends LotrBaseBiome {
    public BlueMountainsBiome(Biome.Precipitation precipType, Biome.Category category, float depth, float scale, float temp, float downfall, int waterFogColor, int fogColor, int foliageColor, int grassColor, int mapColor) {
        super(precipType, category, depth, scale, temp, downfall, waterFogColor, fogColor, foliageColor, grassColor, mapColor);
    }
    public BlueMountainsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 1.0F, 2.2F, 0.22F, 0.8F, -1, -1, -1, -1, 13228770);
    }

    @Override
    public String getName() {
        return "blue_mountains";
    }

    @Override
    public BlockState getTop() {
        return Blocks.SNOW_BLOCK.getDefaultState();
    }

    @Override
    public BlockState getMiddle() {
        return Registry.BLOCK.get(id("blue_rock")).getDefaultState();
    }

    @Override
    public BlockState getBottom() {
        return Blocks.GRAVEL.getDefaultState();
    }

    @Override
    protected void addFeatures(GenerationSettings.Builder builder) {
        super.addFeatures(builder);
    }

    @Override
    protected void addMobs(SpawnSettings.Builder builder) {
        super.addMobs(builder);
    }
    public static class Foothills extends BlueMountainsBiome {
        public Foothills() {
            super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 0.5F, 0.9F, 0.5F, 0.8F, -1, -1, -1, -1, 11253170);
        }

        @Override
        public String getName() {
            return "blue_mountains_foothills";
        }
    }
}
