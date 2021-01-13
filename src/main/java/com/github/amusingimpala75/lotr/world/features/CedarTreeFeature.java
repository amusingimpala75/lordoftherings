package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class CedarTreeFeature extends ExtendedTreeFeature {
    public CedarTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }
    public boolean func_225557_a_(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        //int trunkHeight = config.trunkPlacer.baseHeight + rand.nextInt(config.trunkPlacer.firstRandomHeight + 1) + rand.nextInt(config.trunkPlacer.secondRandomHeight + 1);
        int trunkHeight = config.trunkPlacer.getHeight(rand);
        //int leafHeight = config.trunkHeight >= 0 ? config.trunkHeight + rand.nextInt(config.trunkHeightRandom + 1) : trunkHeight - (config.foliageHeight + rand.nextInt(config.foliageHeightRandom + 1));
        int leafHeight = config.foliagePlacer.getRandomHeight(rand, trunkHeight, config);
        int maxCheckWidth = config.foliagePlacer.getRandomHeight(rand, trunkHeight, config);
        //Optional<BlockPos> canGrow = this.(world, trunkHeight, leafHeight, maxCheckWidth, pos, config);
        if (/*!canGrow.isPresent()*/false) {
            return false;
        } else {
            BlockPos growPos = pos;/*(BlockPos)canGrow.get();*/
            this.setDirtAt(world, growPos.down(), growPos);
            BlockPos.Mutable canopyPos = new BlockPos.Mutable();
            int canopyMin = trunkHeight - 2;

            //int x;
            int z;
            int x;
            int roots;
            for(x = canopyMin; x <= trunkHeight; ++x) {
                z = 2 - (x - trunkHeight);
                canopyPos.set(growPos).move(0, x, 0);
                this.growLeafLayer(world, rand, canopyPos, leaves, bb, config, z);
                if (x == canopyMin) {
                    for(x = -1; x <= 1; ++x) {
                        for(roots = -1; roots <= 1; ++roots) {
                            if (x == 0 || roots == 0) {
                                canopyPos.set(growPos).move(x, x, roots);
                                this.setLog(world, rand, canopyPos, trunk, bb, config);
                            }
                        }
                    }
                }
            }

            for(x = trunkHeight - 1; x > trunkHeight / 2; x -= 1 + rand.nextInt(3)) {
                z = 1 + rand.nextInt(3);

                label134:
                for(x = 0; x < z; ++x) {
                    float angle = rand.nextFloat() * 3.1415927F * 2.0F;
                    int length = MathHelper.nextInt(rand, 4, 7);
                    int leafLayers = 2 + rand.nextInt(2);
                    BlockPos.Mutable branchPos = new BlockPos.Mutable();

                    int l;
                    int leafRange;
                    for(l = 0; l < length; ++l) {
                        leafRange = (int)(0.5F + MathHelper.cos(angle) * (float)(l + 1));
                        int branchZ = (int)(0.5F + MathHelper.sin(angle) * (float)(l + 1));
                        int branchY = x - 3 + l / 2;
                        branchPos.set(growPos).move(leafRange, branchY, branchZ);
                        if (!this.setLog(world, rand, branchPos, trunk, bb, config)) {
                            continue label134;
                        }

                        if (l == length - 1 && leafLayers >= 3) {
                            BlockPos.Mutable woodPos = new BlockPos.Mutable();

                            for(int x2 = -1; x2 <= 1; ++x2) {
                                for(int z2 = -1; z2 <= 1; ++z2) {
                                    if (x2 == 0 || z2 == 0) {
                                        woodPos.set(branchPos).move(x2, -1, z2);
                                        this.setLog(world, rand, woodPos, trunk, bb, config);
                                    }
                                }
                            }
                        }
                    }

                    for(l = 0; l < leafLayers; ++l) {
                        leafRange = 1 + l;
                        this.growLeafLayer(world, rand, branchPos.down(l), leaves, bb, config, leafRange);
                    }
                }
            }

            for(x = 0; x < trunkHeight; ++x) {
                this.setLog(world, rand, growPos.up(x), trunk, bb, config);
            }

            for(x = -1; x <= 1; ++x) {
                for(z = -1; z <= 1; ++z) {
                    if (Math.abs(x) != Math.abs(z)) {
                        BlockPos.Mutable rootPos = (new BlockPos.Mutable(growPos.getX(), growPos.getY(), growPos.getZ())).move(x, rand.nextInt(2), z);
                        roots = 0;

                        while(rootPos.getY() >= 0 && this.canLeavesReplace(world, rootPos, config) && this.placeWood(world, rand, rootPos, trunk, bb, config, Direction.Axis.Y)) {
                            this.setDirtAt(world, rootPos.down(), rootPos);
                            rootPos.move(0, -1, 0);
                            ++roots;
                            if (roots > 4 + rand.nextInt(3)) {
                                break;
                            }
                        }
                    }
                }
            }

            return true;
        }
    }

    private void growLeafLayer(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config, int leafRange) {
        BlockPos.Mutable movingPos = new BlockPos.Mutable();
        int leafRangeSq = leafRange * leafRange;

        for(int x = -leafRange; x <= leafRange; ++x) {
            for(int z = -leafRange; z <= leafRange; ++z) {
                int dSq = x * x + z * z;
                boolean grow = dSq <= leafRangeSq;
                if (grow) {
                    movingPos.set(pos).move(x, 0, z);
                    if (this.canLeavesReplace(world, movingPos, config)) {
                        this.setLeaf(world, rand, movingPos, leaves, bb, config);
                    }
                }
            }
        }
    }

}
