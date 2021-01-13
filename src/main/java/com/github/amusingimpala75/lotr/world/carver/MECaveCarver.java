package com.github.amusingimpala75.lotr.world.carver;

import com.github.amusingimpala75.lotr.world.ModCarvers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.CaveCarver;

import java.util.BitSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class MECaveCarver extends CaveCarver {
    private Set<Block> landOnlyCarvables;

    public MECaveCarver(Codec<ProbabilityConfig> codec) {
        super(codec, 256);
        this.alwaysCarvableBlocks = ModCarvers.listCarvableBlocks();
        this.landOnlyCarvables = ModCarvers.listLandOnlyCarvableBlocks();
    }

    protected boolean canCarve(BlockState state, BlockState aboveState) {
        Block block = state.getBlock();
        return this.canAlwaysCarveBlock(state) || this.landOnlyCarvables.contains(block) && !aboveState.getFluidState().isIn(FluidTags.WATER);
    }

    protected boolean carve(Chunk chunk, Function<BlockPos, Biome> biomeGetter, BitSet bitSet, Random rand, BlockPos.Mutable movingPos, BlockPos.Mutable movingPosAbove, BlockPos.Mutable movingPosBelow, int seaLevel, int chunkX, int chunkZ, int x, int z, int xInChunk, int y, int zInChunk, AtomicBoolean bool, ProbabilityConfig config) {
        boolean flag = super.carve(chunk, biomeGetter, rand, seaLevel, x, z, chunkX, chunkZ,/* xInChunk, y, zInChunk, bool,*/bitSet,  config);
        if (flag) {
            changeOtherBlocksAboveAndBelow(chunk, movingPos, movingPosAbove, movingPosBelow);
        }

        return flag;
    }

    protected static void changeOtherBlocksAboveAndBelow(Chunk chunk, BlockPos.Mutable movingPos, BlockPos.Mutable movingPosAbove, BlockPos.Mutable movingPosBelow) {
        movingPosBelow.set(movingPos).move(Direction.DOWN);
        if (chunk.getBlockState(movingPosBelow).getBlock() == getBlock("dirty_chalk")) {
            chunk.setBlockState(movingPosBelow, getBlock("dirty_chalk").getDefaultState(), false);
        }

    }
    public static Block getBlock(String id) {
        return Registry.BLOCK.get(id(id));
    }
}
