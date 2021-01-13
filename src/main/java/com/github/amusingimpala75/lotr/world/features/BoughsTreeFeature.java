package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.util.math.BlockPos.Mutable;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class BoughsTreeFeature extends ExtendedTreeFeature {
    public BoughsTreeFeature(Codec<TreeFeatureConfig> codec) {
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
            int branchMinHeight = (int)((float)trunkHeight * 0.6F);
            int deg = 0;

            int x;
            int z;
            for(x = trunkHeight; x >= branchMinHeight; --x) {
                z = 1 + rand.nextInt(2);

                for(int b = 0; b < z; ++b) {
                    deg += 50 + rand.nextInt(70);
                    float angle = (float)Math.toRadians((double)deg);
                    float cos = MathHelper.cos(angle);
                    float sin = MathHelper.sin(angle);
                    float angleY = rand.nextFloat() * (float)Math.toRadians(50.0D);
                    float cosY = MathHelper.cos(angleY);
                    float sinY = MathHelper.sin(angleY);
                    int length = 4 + rand.nextInt(6);
                    Mutable branchPos = (new Mutable(growPos.getX(), growPos.getY(), growPos.getZ())).move(0, x, 0);
                    Direction.Axis axis = Direction.fromRotation((double)(deg + 90)).getAxis();

                    for(int l = 0; l < length; ++l) {
                        if (Math.floor((double)(cos * (float)l)) != Math.floor((double)(cos * (float)(l - 1)))) {
                            branchPos.move((int)Math.signum(cos), 0, 0);
                        }

                        if (Math.floor((double)(sin * (float)l)) != Math.floor((double)(sin * (float)(l - 1)))) {
                            branchPos.move(0, 0, (int)Math.signum(sin));
                        }

                        if (Math.floor((double)(sinY * (float)l)) != Math.floor((double)(sinY * (float)(l - 1)))) {
                            branchPos.move(0, (int)Math.signum(sinY), 0);
                        }

                        if (!this.canLeavesReplace(world, branchPos, config)) {
                            break;
                        }

                        this.placeWood(world, rand, branchPos, trunk, bb, config, axis);
                    }

                    this.growLeafCanopy(world, rand, branchPos, leaves, bb, config);
                }
            }

            for(x = 0; x < trunkHeight; ++x) {
                this.setLog(world, rand, growPos.up(x), trunk, bb, config);
            }

            for(x = -1; x <= 1; ++x) {
                for(z = -1; z <= 1; ++z) {
                    if (Math.abs(x) != Math.abs(z)) {
                        Mutable rootPos = (new Mutable(growPos.getX(), growPos.getY(), growPos.getZ())).move(x, rand.nextInt(2), z);
                        int roots = 0;

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

    private void growLeafCanopy(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        int leafStart = -1;
        int leafTop = 2;
        int maxRange = 3 + rand.nextInt(2);
        BlockPos.Mutable movingPos = new BlockPos.Mutable();

        for(int y = leafStart; y <= leafTop; ++y) {
            int leafRangeAdd = -2;
            if (y >= 0) {
                leafRangeAdd = 0 - y;
            }

            int leafRange = maxRange + leafRangeAdd;
            int leafRangeSq = leafRange * leafRange;

            for(int x = -leafRange; x <= leafRange; ++x) {
                for(int z = -leafRange; z <= leafRange; ++z) {
                    int dSq = x * x + z * z;
                    int dCh = Math.abs(x) + Math.abs(y) + Math.abs(z);
                    boolean grow = dSq < leafRangeSq && dCh <= 4;
                    if (Math.abs(x) == leafRange - 1 || Math.abs(z) == leafRange - 1) {
                        grow &= rand.nextInt(4) != 0;
                    }

                    if (grow) {
                        movingPos.set(pos).move(x, y, z);
                        if (this.canLeavesReplace(world, movingPos, config)) {
                            this.setLeaf(world, rand, movingPos, leaves, bb, config);
                        }
                    }
                }
            }
        }

    }
}
