package com.github.amusingimpala75.lotr.world.carver;

import com.github.amusingimpala75.lotr.world.ModCarvers;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.carver.RavineCarver;

import java.util.Set;

public class MECanyonCarver extends RavineCarver {
    private Set<Block> landOnlyCarvables;

    public MECanyonCarver(Codec<ProbabilityConfig> codec) {
        super(codec);
        this.alwaysCarvableBlocks = ModCarvers.listCarvableBlocks();
        this.landOnlyCarvables = ModCarvers.listLandOnlyCarvableBlocks();
    }

    protected boolean canCarveBlock(BlockState state, BlockState aboveState) {
        Block block = state.getBlock();
        return this.canAlwaysCarveBlock(state) || this.landOnlyCarvables.contains(block) && !aboveState.getFluidState().isIn(FluidTags.WATER);
    }
}
