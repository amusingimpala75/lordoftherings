package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;

public class MistyMountainsBiome extends LotrBaseBiome{
    public MistyMountainsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 2.0F, 2.0F, 0.2F, 0.5F, -1, -1, -1, -1, 15263713);
    }
    protected MistyMountainsBiome(Biome.Precipitation precipType, Biome.Category category, float depth, float scale, float temp, float downfall, int waterFogColor, int fogColor, int foliageColor, int grassColor, int mapColor) {
        super(precipType, category, depth, scale, temp, downfall, waterFogColor, fogColor, foliageColor, grassColor, mapColor);
    }

    @Override
    public String getName() {
        return "misty_mountains";
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
    public static class FootHills extends MistyMountainsBiome {
        public FootHills() {
            super(Biome.Precipitation.RAIN, Biome.Category.EXTREME_HILLS, 0.7F, 0.9F, 0.25F, 0.6F, -1, -1, -1, -1, 12501430);
        }

        @Override
        public String getName() {
            return "misty_mountains_foothills";
        }
    }
}
