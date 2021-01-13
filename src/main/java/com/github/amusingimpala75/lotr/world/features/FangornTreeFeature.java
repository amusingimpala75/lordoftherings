package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction;

import java.util.*;
import java.util.function.Predicate;

public class FangornTreeFeature extends ExtendedTreeFeature {
    protected FangornTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }
    private float heightFactor = 1.0F;
    private boolean generateLeaves = true;

    //public FangornTreeFeature(Function<Dynamic<?>, ? extends ExtendedTreeConfig> configFactory) {
    //    super(configFactory);
    //}

    //TODO: Check "fixes" for x1, x12
    public boolean func_225557_a_(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        long time0 = System.nanoTime();
        float randF = MathHelper.nextFloat(rand, 0.5F, 1.0F);
        int height = (int)(randF * 40.0F * this.heightFactor);
        int trunkRadiusMin = (int)(randF * 5.0F);
        int trunkRadiusMax = trunkRadiusMin + 4;
        int xSlope = MathHelper.nextInt(rand, 4, 10) * (rand.nextBoolean() ? -1 : 1);
        int zSlope = MathHelper.nextInt(rand, 4, 10) * (rand.nextBoolean() ? -1 : 1);
        Optional<BlockPos> canGrow = this.func_227212_a_(world, height, height, trunkRadiusMax, pos, config);
        if (!canGrow.isPresent()) {
            return false;
        } else {
            BlockPos growPos = (BlockPos)canGrow.get();
            Mutable offsetCentrePos = new Mutable(growPos.getX(), growPos.getY(), growPos.getZ());
            Set<BlockPos> strippedLogTrunkPositions = new HashSet();
            Mutable movingPos = new Mutable();

            int woodBelow;
            int maxWoodBelow;
            for(int y = 0; y < height; ++y) {
                float heightF = (float)y / (float)height;
                int width = trunkRadiusMax - (int)(heightF * (float)(trunkRadiusMax - trunkRadiusMin));

                for(int x = -width; x <= width; ++x) {
                    for(int z = -width; z <= width; ++z) {
                        movingPos.set(offsetCentrePos).move(x, y, z);
                        if (x * x + z * z < width * width) {
                            if (this.placeStrippedLog(world, rand, movingPos, trunk, bb, config, Direction.Axis.Y)) {
                                strippedLogTrunkPositions.add(movingPos.toImmutable());
                            }

                            if (y == 0) {
                                this.setDirtAt(world, movingPos.down(), movingPos);
                                Mutable woodBelowPos = new Mutable(movingPos.down().getX(), movingPos.down().getY(), movingPos.down().getZ());
                                woodBelow = 0;
                                maxWoodBelow = 6 + rand.nextInt(5);

                                while(woodBelowPos.getY() >= 0 && this.placeStrippedLog(world, rand, woodBelowPos, trunk, bb, config, Direction.Axis.Y)) {
                                    strippedLogTrunkPositions.add(woodBelowPos.toImmutable());
                                    this.setDirtAt(world, woodBelowPos.down(), woodBelowPos);
                                    woodBelowPos.move(Direction.DOWN);
                                    ++woodBelow;
                                    if (woodBelow > maxWoodBelow) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                if (y % xSlope == 0) {
                    if (xSlope > 0) {
                        offsetCentrePos.move(Direction.EAST);
                    } else if (xSlope < 0) {
                        offsetCentrePos.move(Direction.WEST);
                    }
                }

                if (y % zSlope == 0) {
                    if (zSlope > 0) {
                        offsetCentrePos.move(Direction.SOUTH);
                    } else if (zSlope < 0) {
                        offsetCentrePos.move(Direction.NORTH);
                    }
                }
            }

            long timeBeforeTrunk = System.nanoTime();
            Predicate<BlockState> notWood = (state) -> !state.isIn(BlockTags.LOGS);
            Iterator var59 = strippedLogTrunkPositions.iterator();

            while(true) {
                while(var59.hasNext()) {
                    BlockPos strippedPos = (BlockPos)var59.next();
                    Direction[] var62 = Direction.values();
                    woodBelow = var62.length;

                    for(maxWoodBelow = 0; maxWoodBelow < woodBelow; ++maxWoodBelow) {
                        Direction checkDir = var62[maxWoodBelow];
                        if (world.testBlockState(strippedPos.offset(checkDir), notWood)) {
                            world.setBlockState(strippedPos, config.woodProvider.getBlockState(rand, strippedPos), 19);
                            break;
                        }
                    }
                }

                long timeAfterTrunk = System.nanoTime();
                int angle = 0;

                while(angle < 360) {
                    angle += 10 + rand.nextInt(20);
                    float angleR = (float)Math.toRadians((double)angle);
                    float sin = MathHelper.sin(angleR);
                    float cos = MathHelper.cos(angleR);
                    int boughLength = 12 + rand.nextInt(10);
                    int boughThickness = Math.round((float)boughLength / 25.0F * 1.5F);
                    int boughBaseHeight = MathHelper.floor((float)height * (0.9F + rand.nextFloat() * 0.1F));
                    int boughHeight = 3 + rand.nextInt(4);

                    for(int l = 0; l < boughLength; ++l) {
                        int x = Math.round(cos * (float)l);
                        int z = Math.round(sin * (float)l);
                        int y = boughBaseHeight + Math.round((float)l / (float)boughLength * (float)boughHeight);
                        int range = boughThickness - Math.round((float)l / (float)boughLength * (float)boughThickness * 0.5F);

                        int x1;
                        for(x1 = -range; x1 <= range; ++x1) {
                            for(int y1 = -range; y1 <= range; ++y1) {
                                for(int z1 = -range; z1 <= range; ++z1) {
                                    movingPos.set(offsetCentrePos).move(x + x1, y + y1, z + z1);
                                    this.placeWood(world, rand, movingPos, trunk, bb, config, Direction.Axis.Y);
                                }
                            }
                        }

                        x1 = angle + rand.nextInt(360);
                        float branch_angleR = (float)Math.toRadians((double)x1);
                        float branch_sin = MathHelper.sin(branch_angleR);
                        float branch_cos = MathHelper.cos(branch_angleR);
                        int branchLength = 7 + rand.nextInt(6);
                        int branchHeight = rand.nextInt(6);
                        int leafRange = 3;

                        for(int l1 = 0; l1 < branchLength; ++l1) {
                            int x12 = x + Math.round(branch_cos * (float)l1);
                            int z1 = z + Math.round(branch_sin * (float)l1);
                            int y1 = y + Math.round((float)l1 / (float)branchLength * (float)branchHeight);

                            int x2;
                            for(x2 = 0; x2 >= -1; --x2) {
                                movingPos.set(offsetCentrePos).move(x12, y1 + x2, z1);
                                this.placeWood(world, rand, movingPos, trunk, bb, config, Direction.Axis.Y);
                            }

                            if (this.generateLeaves && l1 == branchLength - 1) {
                                for(x2 = -leafRange; x2 <= leafRange; ++x2) {
                                    for(int y2 = -leafRange; y2 <= leafRange; ++y2) {
                                        for(int z2 = -leafRange; z2 <= leafRange; ++z2) {
                                            int dSq = x2 * x2 + y2 * y2 + z2 * z2;
                                            if (dSq < (leafRange - 1) * (leafRange - 1) || dSq < leafRange * leafRange && rand.nextInt(3) != 0) {
                                                movingPos.set(offsetCentrePos).move(x12 + x2, y1 + y2, z1 + z2);
                                                this.setLeaf(world, rand, movingPos, leaves, bb, config);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                long time1 = System.nanoTime();
                return true;
            }
        }
    }

    public Optional<BlockPos> func_227212_a_(ModifiableTestableWorld world, int trunkHeight, int leafHeight, int maxCheckWidth, BlockPos pos, TreeFeatureConfig config) {
        BlockPos growPos;
        int y;
        int checkWidth;
        if (!config.skipFluidCheck) {
            y = world.getTopPosition(Heightmap.Type.OCEAN_FLOOR, pos).getY();
            checkWidth = world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).getY();
            growPos = new BlockPos(pos.getX(), y, pos.getZ());
            if (checkWidth - y > config.maxWaterDepth) {
                return Optional.empty();
            }
        } else {
            growPos = pos;
        }

        if (growPos.getY() >= 1 && growPos.getY() + trunkHeight + 1 <= /*world.getMaxHeight()*/256) {
            for(y = 0; y <= trunkHeight + 1; ++y) {
                checkWidth = maxCheckWidth;
                Mutable checkPos = new Mutable();

                for(int x = -maxCheckWidth; x <= checkWidth; ++x) {
                    for(int z = -checkWidth; z <= checkWidth; ++z) {
                        if (y + growPos.getY() < 0 || y + growPos.getY() >= 256/*world.getMaxHeight()*/) {
                            return Optional.empty();
                        }

                        checkPos.set(x + growPos.getX(), y + growPos.getY(), z + growPos.getZ());
                        if (!canTreeReplace(world, checkPos)/* || !config.ignoreVines && isVine(world, checkPos)*/) {
                            return Optional.empty();
                        }
                    }
                }
            }

            return isSoil(world, growPos.down()/*, config.getSapling()*/) && growPos.getY() < 256/*world.getMaxHeight()*/ - trunkHeight - 1 ? Optional.of(growPos) : Optional.empty();
        } else {
            return Optional.empty();
        }
    }
}
