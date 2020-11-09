package com.github.amusingimpala75.lotr.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class ShireWoodlandsBiome extends ShireBiome {
    public ShireWoodlandsBiome() {
        super(Biome.Precipitation.RAIN, Biome.Category.FOREST, 0.3F, 0.5F, 0.8F, 0.9F, -1, -1, -1, 4486966);
    }

    @Override
    protected void addMobs(SpawnSettings.Builder builder) {
        super.addMobs(builder);
    }

    @Override
    public String getName() {
        return "shire_woodlands";
    }
}
