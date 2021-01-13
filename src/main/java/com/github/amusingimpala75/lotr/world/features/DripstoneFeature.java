package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.block.Dripstone;
import com.github.amusingimpala75.lotr.block.DripstoneTypes;
import com.github.amusingimpala75.lotr.world.features.config.DripstoneFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class DripstoneFeature extends Feature<DripstoneFeatureConfig> {
    public DripstoneFeature(Codec<DripstoneFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator/*<? extends GenerationSettings>*/ generator, Random rand, BlockPos pos, DripstoneFeatureConfig config) {
        boolean placedAny = false;
        BlockPos.Mutable movingPos = new BlockPos.Mutable();

        for(int l = 0; l < config.tries; ++l) {
            int x = pos.getX() - rand.nextInt(config.xspread) + rand.nextInt(config.xspread);
            int y = pos.getY() - rand.nextInt(config.yspread) + rand.nextInt(config.yspread);
            int z = pos.getZ() - rand.nextInt(config.zspread) + rand.nextInt(config.zspread);
            movingPos.move(x, y, z);
            Block above = world.getBlockState(movingPos.up()).getBlock();
            Block below = world.getBlockState(movingPos.down()).getBlock();
            boolean waterlogged = world.getFluidState(movingPos).getFluid() == Fluids.WATER;
            boolean isForcedBlock = config.hasForcedDripstoneState();
            boolean canPlaceStalac = isForcedBlock ? ((BlockState)config.forcedBlockState.with(Dripstone.TYPE, DripstoneTypes.C)).canPlaceAt(world, movingPos) : Dripstone.BLOCK_TO_DRIPSTONE.containsKey(above);
            boolean canPlaceStalag = isForcedBlock ? ((BlockState)config.forcedBlockState.with(Dripstone.TYPE, DripstoneTypes.G)).canPlaceAt(world, movingPos) : Dripstone.BLOCK_TO_DRIPSTONE.containsKey(below);
            boolean placed = false;
            BlockState stalag;
            BlockState placeState;
            BlockState placeStateUp;
            boolean waterloggedUp;
            if (canPlaceStalac) {
                stalag = isForcedBlock ? config.forcedBlockState : ((Dripstone)Dripstone.BLOCK_TO_DRIPSTONE.get(above)).getDefaultState();
                if (this.canDripstoneReplace(stalag, world.toServerWorld(), movingPos)) {
                    if (rand.nextFloat() < config.doubleChance && this.canDripstoneReplace(stalag, world.toServerWorld(), movingPos.down())) {
                        waterloggedUp = world.getFluidState(movingPos.down()).getFluid() == Fluids.WATER;
                        placeState = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.C_DOUBLE_BASE), waterlogged);
                        placeStateUp = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.C_DOUBLE_POINT), waterloggedUp);
                        world.setBlockState(movingPos, placeState, 2);
                        world.setBlockState(movingPos.down(), placeStateUp, 2);
                        placed = true;
                    } else {
                        placeState = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.C), waterlogged);
                        world.setBlockState(movingPos, placeState, 2);
                        placed = true;
                    }
                }
            }

            if (!placed && canPlaceStalag) {
                stalag = isForcedBlock ? config.forcedBlockState : ((Dripstone)Dripstone.BLOCK_TO_DRIPSTONE.get(below)).getDefaultState();
                if (this.canDripstoneReplace(stalag, world.toServerWorld(), movingPos)) {
                    if (rand.nextFloat() < config.doubleChance && this.canDripstoneReplace(stalag, world.toServerWorld(), movingPos.up())) {
                        waterloggedUp = world.getFluidState(movingPos.up()).getFluid() == Fluids.WATER;
                        placeState = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.G_DOUBLE_BASE), waterlogged);
                        placeStateUp = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.G_DOUBLE_POINT), waterloggedUp);
                        world.setBlockState(movingPos, placeState, 2);
                        world.setBlockState(movingPos.up(), placeStateUp, 2);
                        placed = true;
                    } else {
                        placeState = this.waterlogIfApplicable((BlockState)stalag.with(Dripstone.TYPE, DripstoneTypes.G), waterlogged);
                        world.setBlockState(movingPos, placeState, 2);
                        placed = true;
                    }
                }
            }

            placedAny |= placed;
        }

        return placedAny;
    }

    private boolean canDripstoneReplace(BlockState state, World world, BlockPos pos) {
        if (world.isAir(pos)) {
            return true;
        } else if (world.getBlockState(pos).getBlock() != Blocks.WATER) {
            return false;
        } else {
            Block block = state.getBlock();
            return block instanceof Dripstone && ((Dripstone)block).isWaterloggable;
        }
    }

    private BlockState waterlogIfApplicable(BlockState state, boolean waterlogged) {
        Block block = state.getBlock();
        if (block instanceof Dripstone && ((Dripstone)block).isWaterloggable) {
            state = (BlockState)state.with(Dripstone.WATERLOGGED, waterlogged);
        }

        return state;
    }
}
