package com.github.amusingimpala75.lotr.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class WeightedRandomFeature extends Feature<WeightedRandomFeatureConfig> {
    public WeightedRandomFeature(Codec<WeightedRandomFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator/*<? extends GenerationSettings>*/ generator, Random rand, BlockPos pos, WeightedRandomFeatureConfig config) {
        ConfiguredFeature<?, ?> selectedFeature = config.getRandomFeature(rand);
        return selectedFeature.generate(world, generator, rand, pos);
    }
}
