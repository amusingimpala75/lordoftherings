package com.github.amusingimpala75.lotr.world;

import com.github.amusingimpala75.lotr.world.carver.MECanyonCarver;
import com.github.amusingimpala75.lotr.world.carver.MECaveCarver;
import com.github.amusingimpala75.lotr.world.carver.MEUnderwaterCanyonCarver;
import com.github.amusingimpala75.lotr.world.carver.MEUnderwaterCaveCarver;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.Carver;

import java.util.Set;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class ModCarvers {
    public static final Carver<ProbabilityConfig> CAVE;
    public static final Carver<ProbabilityConfig> CANYON;
    public static final Carver<ProbabilityConfig> UNDERWATER_CAVE;
    public static final Carver<ProbabilityConfig> UNDERWATER_CANYON;
    public ModCarvers() {
    }

    public static MECaveCarver createMECave() {
        return new MECaveCarver(ProbabilityConfig.CODEC);
    }

    public static MECanyonCarver createMECanyon() {
        return new MECanyonCarver(ProbabilityConfig.CODEC);
    }

    public static MEUnderwaterCaveCarver createMEUnderwaterCave() {
        return new MEUnderwaterCaveCarver(ProbabilityConfig.CODEC);
    }

    public static MEUnderwaterCanyonCarver createMEUnderwaterCanyon() {
        return new MEUnderwaterCanyonCarver(ProbabilityConfig.CODEC);
    }

    public static Set<Block> listCarvableBlocks() {
        return ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE, getBlock("mordor_rock"), getBlock("gondor_rock"), getBlock("rohan_rock"), getBlock("blue_rock"), getBlock("red_rock"), getBlock("chalk"), getBlock("dirty_chalk"), Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL, Blocks.GRASS_BLOCK, getBlock("mordor_dirt"), Blocks.SANDSTONE, Blocks.RED_SANDSTONE, getBlock("white_sandstone"), Blocks.MYCELIUM, Blocks.SNOW, Blocks.PACKED_ICE);
    }

    public static Set<Block> listLandOnlyCarvableBlocks() {
        return ImmutableSet.of(Blocks.SAND, Blocks.RED_SAND, getBlock("white_sand"), Blocks.GRAVEL, getBlock("mordor_gravel"));
    }

    public static Set<Block> listUnderwaterCarvableBlocks() {
        return (new ImmutableSet.Builder()).addAll(listCarvableBlocks()).addAll(listLandOnlyCarvableBlocks()).add(new Object[]{Blocks.WATER, Blocks.LAVA, Blocks.OBSIDIAN, Blocks.AIR, Blocks.CAVE_AIR}).build();
    }

    static {
        CAVE = Registry.register(Registry.CARVER, id("cave"), createMECave());
        CANYON = Registry.register(Registry.CARVER, id("canyon"), createMECanyon());
        UNDERWATER_CAVE = Registry.register(Registry.CARVER, id("underwater_cave"), createMEUnderwaterCave());
        UNDERWATER_CANYON = Registry.register(Registry.CARVER, id("underwater_canyon"), createMEUnderwaterCanyon());
    }
    public static Block getBlock(String id) {
        return Registry.BLOCK.get(id(id));
    }
    public static void registerCarvers() {}
}
