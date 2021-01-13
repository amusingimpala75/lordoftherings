package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.DeadTreeFeatureConfig;
import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.util.math.BlockPos.Mutable;

import java.util.Iterator;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class DeadTreeFeature extends ExtendedTreeFeature {
    public DeadTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }
    public boolean func_225557_a_(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, DeadTreeFeatureConfig config) {
        //int trunkHeight = config.field_227371_p_ + rand.nextInt(config.heightRandA + 1) + rand.nextInt(config.heightRandB + 1);
        int trunkHeight = config.trunkPlacer.getHeight(rand);
        int maxCheckWidth = 2;
        Optional<BlockPos> optional = this.canGrow(world, trunkHeight, trunkHeight, maxCheckWidth, pos, config);
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos treePos = (BlockPos)optional.get();
            this.setDirtAt(world, treePos.down(), treePos);

            for(int y = 0; y < trunkHeight; ++y) {
                this.setLog(world, rand, treePos.up(y), trunk, bb, config);
            }

            if (trunkHeight >= 4) {
                Mutable branchPos = new Mutable();
                Iterator var14 = Direction.Type.HORIZONTAL.iterator();

                while(var14.hasNext()) {
                    Direction dir = (Direction)var14.next();
                    int branchLength = 2 + rand.nextInt(4);
                    int branchOut = 0;
                    int branchUp = trunkHeight - rand.nextInt(3);

                    for(int l = 0; l < branchLength; ++l) {
                        if (rand.nextInt(4) == 0) {
                            ++branchOut;
                        }

                        if (l > 0 && rand.nextInt(3) != 0) {
                            ++branchUp;
                        }

                        branchPos.set(treePos.up(branchUp).offset(dir, branchOut));
                        this.setWood(world, rand, branchPos, trunk, bb, config);
                    }
                }
            }

            return true;
        }
    }

    protected boolean setWood(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> set, BlockBox bb, DeadTreeFeatureConfig config) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, config.woodProvider.getBlockState(rand, pos));
            set.add(pos.toImmutable());
            return true;
        }
    }

    private Optional<BlockPos> canGrow(ModifiableTestableWorld world, int trunkHeight, int leafHeight, int maxCheckWidth, BlockPos pos, DeadTreeFeatureConfig config) {
        BlockPos blockpos;
        int y;
        int checkWidth;
        if (!config.skipFluidCheck) {
            y = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos).getY();
            checkWidth = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).getY();
            blockpos = new BlockPos(pos.getX(), y, pos.getZ());
            int maxWaterDepth = 0;
            if (checkWidth - y > maxWaterDepth) {
                return Optional.empty();
            }
        } else {
            blockpos = pos;
        }

        if (blockpos.getY() >= 1 && blockpos.getY() + trunkHeight + 1 <= /*world.getMaxHeight()*/256) {
            for(y = 0; y <= trunkHeight + 1; ++y) {
                checkWidth = maxCheckWidth;
                Mutable blockpos$mutable = new Mutable();

                for(int x = -maxCheckWidth; x <= checkWidth; ++x) {
                    for(int z = -checkWidth; z <= checkWidth; ++z) {
                        if (y + blockpos.getY() < 0 || y + blockpos.getY() >= /*world.getMaxHeight()*/256) {
                            return Optional.empty();
                        }

                        blockpos$mutable.set(x + blockpos.getX(), y + blockpos.getY(), z + blockpos.getZ());
                        boolean ignoreVines = false;
                        if (!canTreeReplace(world, blockpos$mutable)/* || !ignoreVines && isVine(world, blockpos$mutable)*/) {
                            return Optional.empty();
                        }
                    }
                }
            }

            return this.isValidSurface(world, blockpos.down()) && blockpos.getY() < /*world.getMaxHeight()*/256 - trunkHeight - 1 ? Optional.of(blockpos) : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    //TODO: Fix block tags
    private boolean isValidSurface(ModifiableTestableWorld world, BlockPos pos) {
        return isSoil(world, pos) || world.testBlockState(pos, (state) -> {
            //return state.isIn(Blocks.MORDOR_PLANT_SURFACES);
            return state.isIn(BlockTags.BAMBOO_PLANTABLE_ON);
        });
    }
    public boolean setLog(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> logs, BlockBox bb, DeadTreeFeatureConfig config) {
        if (!canReplace(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, config.trunkProvider.getBlockState(rand, pos));
            return true;
        }
    }
}
