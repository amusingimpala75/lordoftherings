package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;
import java.util.Set;

//TODO: Fix
public abstract class ExtendedTreeFeature extends TreeFeature {
    public ExtendedTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }
    //public ExtendedTreeFeature(Function<Dynamic<?>, ? extends T> configFactory) {
    //    super(configFactory);
    //}

    protected boolean placeWood(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, BlockBox bb, ExtendedTreeConfig config, Direction.Axis axis) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, (BlockState)config.woodProvider.getBlockState(rand, pos).with(PillarBlock.AXIS, axis)/*, bb*/);
            trunk.add(pos.toImmutable());
            return true;
        }
    }

    protected boolean placeStrippedLog(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, BlockBox bb, ExtendedTreeConfig config, Direction.Axis axis) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, (BlockState)config.strippedLogProvider.getBlockState(rand, pos).with(PillarBlock.AXIS, axis));
            trunk.add(pos.toImmutable());
            return true;
        }
    }

    protected boolean canLeavesReplace(ModifiableTestableWorld world, BlockPos pos, ExtendedTreeConfig config) {
        return canTreeReplace(world, pos) && (config.ignoreVines/* || !isVine(world, pos)*/);
    }

    public boolean setLeaf(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, (BlockState)config.leavesProvider.getBlockState(rand, pos)/*.with(PillarBlock.AXIS, axis)*//*, bb*/);
            //trunk.add(pos.toImmutable());
            return true;
        }
    }
    public boolean setLog(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> logs, BlockBox bb, ExtendedTreeConfig config) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, config.trunkProvider.getBlockState(rand, pos));
            return true;
        }
    }
    //TODO: Check if works
    public boolean setDirtAt(ModifiableTestableWorld world, BlockPos pos, BlockPos otherPos) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, Blocks.DIRT.getDefaultState());
            return true;
        }
    }
}
