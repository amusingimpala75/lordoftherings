package com.github.amusingimpala75.lotr.world.features;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class AspenSaplingGen extends SaplingGenerator {
    public AspenSaplingGen() {
    }

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        System.out.println("Aspen Tree Sapling Generator");
        return Features.ASPEN_TREE;
    }
}