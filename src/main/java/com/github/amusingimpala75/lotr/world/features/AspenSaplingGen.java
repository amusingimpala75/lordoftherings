package com.github.amusingimpala75.lotr.world.features;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
/*
Sapling->Tree generator for Aspen
 */
public class AspenSaplingGen extends SaplingGenerator {
    @Nullable
    public ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return Features.ASPEN_TREE;
    }
}