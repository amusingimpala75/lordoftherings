package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.block.MirkOakLeaves;
import com.github.amusingimpala75.lotr.world.features.config.ExtendedTreeConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;

import java.util.Iterator;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class MirkOakTreeFeature extends ExtendedTreeFeature {
    private boolean isDead = false;
    private int trunkWidth = 0;

    public MirkOakTreeFeature(Codec<TreeFeatureConfig> codec) {
        super(codec);
    }

    //public MirkOakTreeFeature(Function<Dynamic<?>, ? extends ExtendedTreeConfig> configFactory) {
    //    super(configFactory);
    //}

    public boolean generate(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        //int trunkHeight = config.trunkPlacer.baseHeight + rand.nextInt(config.trunkPlacer.firstRandomHeight + 1) + rand.nextInt(config.trunkPlacer.secondRandomHeight + 1);
        int trunkHeight = config.trunkPlacer.getHeight(rand);
        //int leafHeight = config.field_227330_d_ >= 0 ? config.field_227330_d_ + rand.nextInt(config.field_227331_f_ + 1) : trunkHeight - (((BlobFoliagePlacer)config.foliagePlacer).height + rand.nextInt(config.field_227335_j_ + 1));
        int leafHeight = config.foliagePlacer.getRandomHeight(rand, trunkHeight, config);
        int maxCheckWidth = config.foliagePlacer.getRandomHeight(rand, /*leafHeight, */trunkHeight, config);
       // Optional<BlockPos> canGrow = this.func_227212_a_(world, trunkHeight, leafHeight, maxCheckWidth, pos, config);
        if (/*!canGrow.isPresent()*/false) {
            return false;
        } else {
            BlockPos growPos = (BlockPos)pos;/*canGrow.get();*/
            this.setDirtAt(world, growPos.down(), growPos);

            for(int y = 0; y < trunkHeight; ++y) {
                this.setLog(world, rand, growPos.up(y), trunk, bb, config);
            }

            this.growLeafCanopy(world, rand, pos.up(trunkHeight - 1), trunk, leaves, bb, config);
            boolean hasRoots = true;
            if (hasRoots) {
                int roots = 4 + rand.nextInt(5 * this.trunkWidth + 1);

                for(int l = 0; l < roots; ++l) {
                    BlockPos.Mutable rootPos = (new BlockPos.Mutable(growPos.getX(), growPos.getY(), growPos.getZ())).move(Direction.UP, 1 + rand.nextInt(this.trunkWidth * 2 + 1));
                    int rootLength = 4 + rand.nextInt(4);
                    Direction rootDir = Direction.Type.HORIZONTAL.random(rand);
                    rootPos.move(rootDir, this.trunkWidth + 1);
                    rootPos.move(rootDir.rotateYClockwise(), MathHelper.nextInt(rand, this.trunkWidth - 1, this.trunkWidth + 1));
                    int rootBlocks = 0;

                    while(rootPos.getY() >= 0 && this.canLeavesReplace(world, rootPos, config) && this.placeWood(world, rand, rootPos, trunk, bb, config, Direction.Axis.Y)) {
                        this.setDirtAt(world, rootPos.down(), rootPos);
                        rootPos.move(0, -1, 0);
                        if (rand.nextBoolean()) {
                            rootPos.move(rootDir, 1);
                        }

                        ++rootBlocks;
                        if (rootBlocks > rootLength) {
                            break;
                        }
                    }
                }
            }

            if (world instanceof World) {
                World iworld = (World) world;
                Iterator var22 = leaves.iterator();

                while(var22.hasNext()) {
                    BlockPos leavesPos = (BlockPos)var22.next();
                    BlockState leavesState = iworld.getBlockState(leavesPos);
                    if (leavesState.getBlock() instanceof MirkOakLeaves) {
                        BlockPos belowLeavesPos = leavesPos.down();
                        leavesState = leavesState.getStateForNeighborUpdate(Direction.DOWN, iworld.getBlockState(belowLeavesPos), iworld, leavesPos, belowLeavesPos);
                        iworld.setBlockState(leavesPos, leavesState, 3);
                    }
                }
            }

            return true;
        }
    }

    private void growLeafCanopy(ModifiableTestableWorld world, Random rand, BlockPos pos, Set<BlockPos> trunk, Set<BlockPos> leaves, BlockBox bb, ExtendedTreeConfig config) {
        int leafStart = 2;
        int leafTop = leafStart + 3;
        int maxRange = 3 + rand.nextInt(2);
        BlockPos.Mutable movingPos;
        int y;
        int dy;
        int leafRange;
        int xa;
        int x;
        if (!this.isDead) {
            movingPos = new BlockPos.Mutable();

            for(y = leafStart; y <= leafTop; ++y) {
                dy = y - leafTop;
                leafRange = maxRange - dy;
                xa = leafRange * leafRange;

                for(x = -leafRange; x <= leafRange; ++x) {
                    for(int z = -leafRange; z <= leafRange; ++z) {
                        movingPos.set(pos).move(x, y, z);
                        int dist = x * x + z * z;
                        boolean grow = dist < xa;
                        if (Math.abs(x) == leafRange - 1 || Math.abs(z) == leafRange - 1) {
                            grow &= rand.nextInt(4) > 0;
                        }

                        if (grow) {
                            int leavesBelow = 0;
                            if (config.isMirky && y == leafStart && Math.abs(x) <= maxRange && Math.abs(z) <= maxRange && rand.nextInt(3) == 0) {
                                ++leavesBelow;
                            }

                            for(int y1 = dy; y1 >= dy - leavesBelow; --y1) {
                                movingPos.move(Direction.DOWN);
                                if (this.canLeavesReplace(world, movingPos, config)) {
                                    this.setLeaf(world, rand, movingPos, leaves, bb, config);
                                }
                            }
                        }
                    }
                }
            }
        }

        movingPos = new BlockPos.Mutable();

        for(y = 0; y <= 2; ++y) {
            for(dy = -maxRange; dy <= maxRange; ++dy) {
                for(leafRange = -maxRange; leafRange <= maxRange; ++leafRange) {
                    movingPos.set(pos).move(dy, y, leafRange);
                    xa = Math.abs(dy);
                    x = Math.abs(leafRange);
                    if (xa == 0 && x == 0 || xa == x && xa == y || (xa == 0 || x == 0) && xa != x && (xa == y + 1 || x == y + 1)) {
                        this.placeWood(world, rand, movingPos, trunk, bb, config, Direction.Axis.Y);
                    }
                }
            }
        }

    }

}
