package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.util.math.BlockPos.Mutable;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class DesertTreeFeature extends ExtendedTreeFeature {
    public DesertTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }

    public boolean func_225557_a_(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        //int trunkHeight = config.field_227371_p_ + rand.nextInt(config.field_227328_b_ + 1) + rand.nextInt(config.field_227329_c_ + 1);
        int trunkHeight = config.trunkPlacer.getHeight(rand);
        //int leafHeight = config.field_227330_d_ >= 0 ? config.field_227330_d_ + rand.nextInt(config.field_227331_f_ + 1) : trunkHeight - (config.field_227334_i_ + rand.nextInt(config.field_227335_j_ + 1));
        int leafHeight = config.foliagePlacer.getRandomHeight(rand, trunkHeight, config);
        int maxCheckWidth = config.foliagePlacer.getRandomRadius(rand, leafHeight/*, trunkHeight, config*/);
        Optional<BlockPos> optional = this.func_227212_a_(world, trunkHeight, leafHeight, maxCheckWidth, pos, config);
        if (!optional.isPresent()) {
            return false;
        } else {
            BlockPos growPos = (BlockPos)optional.get();
            this.setDirtAt(world, growPos.down(), growPos);
            //int trunkTopOffset = config.trunkPlacer.getHeight(rand) + rand.nextInt(config.field_227333_h_ + 1);
            int trunkTopOffset = config.foliagePlacer.getRandomHeight(rand, trunkHeight, config);
            int branches = 4;

            for(int branch = 0; branch < branches; ++branch) {
                int branchLength = 1 + rand.nextInt(3);
                int branchHeight = trunkHeight - trunkTopOffset - 1 - rand.nextInt(2);
                Mutable branchPos = (new Mutable(growPos.getX(), growPos.getY(), growPos.getZ())).move(0, branchHeight, 0);

                for(int l = 0; l < branchLength; ++l) {
                    if (rand.nextInt(3) != 0) {
                        branchPos.move(Direction.UP);
                    }

                    if (rand.nextInt(3) != 0) {
                        switch(branch) {
                            case 0:
                                branchPos.move(Direction.WEST);
                                break;
                            case 1:
                                branchPos.move(Direction.EAST);
                                break;
                            case 2:
                                branchPos.move(Direction.NORTH);
                                break;
                            case 3:
                                branchPos.move(Direction.SOUTH);
                        }
                    }

                    if (!this.setLog(world, rand, branchPos, trunk, bb, config)) {
                        break;
                    }
                }

                int leafStart = 1;
                int leafRangeMin = 0;
                Mutable leafPos = new Mutable();

                for(int y = -leafStart; y <= 1; ++y) {
                    int leafRange = leafRangeMin + 1 - y / 2;

                    for(int x = -leafRange; x <= leafRange; ++x) {
                        for(int z = -leafRange; z <= leafRange; ++z) {
                            if (Math.abs(x) != leafRange || Math.abs(z) != leafRange || rand.nextInt(2) != 0 && y != 0) {
                                leafPos.set(branchPos).move(x, y, z);
                                this.setLeaf(world, rand, leafPos, leaves, bb, config);
                            }
                        }
                    }
                }
            }
            //TODO: FOR WHAT IS THIS?
            //this.func_227213_a_(world, rand, trunkHeight, growPos, trunkTopOffset, trunk, bb, config);
            return true;
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

        if (growPos.getY() >= 1 && growPos.getY() + trunkHeight + 1 <= 256/*world.getMaxHeight()*/) {
            for(y = 0; y <= trunkHeight + 1; ++y) {
                //TODO: CHECK
                checkWidth = config.foliagePlacer.getRandomRadius(new Random(), leafHeight);
                Mutable checkPos = new Mutable();

                for(int x = -checkWidth; x <= checkWidth; ++x) {
                    for(int z = -checkWidth; z <= checkWidth; ++z) {
                        if (y + growPos.getY() < 0 || y + growPos.getY() >= 256/*world.getMaxHeight()*/) {
                            return Optional.empty();
                        }

                        checkPos.set(x + growPos.getX(), y + growPos.getY(), z + growPos.getZ());
                        if (!canReplace(world, pos)) {
                            return Optional.empty();
                        }
                    }
                }
            }

            return this.canGrowOn(world, growPos.down()) && growPos.getY() < /*world.getMaxHeight()*/256 - trunkHeight - 1 ? Optional.of(growPos) : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    private boolean canGrowOn(ModifiableTestableWorld world, BlockPos soilPos) {
        return isSoil(world, soilPos) || world.testBlockState(soilPos, (state) -> {
            return state.isIn(BlockTags.SAND) /*|| state.isIn(Blocks.SANDSTONE) */|| state.getBlock() == Blocks.STONE;
        });

    }
}
