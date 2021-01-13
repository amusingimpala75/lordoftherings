package com.github.amusingimpala75.lotr.world.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class LeafBushesFeature extends Feature<DefaultFeatureConfig> {
    public LeafBushesFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator/*<? extends GenerationSettings>*/ generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        BlockState leafBlockState = null;
        BlockPos.Mutable movingPos = new BlockPos.Mutable();
        int tries = 40;
        int searchXZ = 6;
        int searchUpY = 12;

        int size;
        for(int l = 0; l < tries; ++l) {
            int x = MathHelper.nextInt(rand, -searchXZ, searchXZ);
            size = rand.nextInt(searchUpY + 1);
            int z = MathHelper.nextInt(rand, -searchXZ, searchXZ);
            movingPos.set(pos).move(x, size, z);
            BlockState state = world.getBlockState(movingPos);
            if (state.isIn(BlockTags.LEAVES)) {
                leafBlockState = state.getBlock().getDefaultState();
                if (leafBlockState.get(LeavesBlock.PERSISTENT)) {
                    leafBlockState = (BlockState)leafBlockState.with(LeavesBlock.PERSISTENT, true);
                }
                break;
            }
        }

        if (leafBlockState != null) {
            BlockPos belowPos = pos.down();
            BlockState below = world.getBlockState(belowPos);
            if (BlockTags.BAMBOO_PLANTABLE_ON.contains(below.getBlock())) {     //TODO: Check if it works
                size = 0;
                if (rand.nextInt(3) == 0) {
                    ++size;
                }

                int y = 0;

                for(int x = -size; x <= size; ++x) {
                    for(int z = -size; z <= size; ++z) {
                        if (size == 0 || Math.abs(x) != size || Math.abs(z) != size || rand.nextInt(3) == 0) {
                            movingPos.set(pos).move(x, y, z);
                            BlockState state = world.getBlockState(movingPos);
                            if (!state.getMaterial().isLiquid() && state.getMaterial().isReplaceable()) {
                                world.setBlockState(movingPos, leafBlockState, 2);
                            }
                        }
                    }
                }

                return true;
            }
        }

        return false;
    }
}
