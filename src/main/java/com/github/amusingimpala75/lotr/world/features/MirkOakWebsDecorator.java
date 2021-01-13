package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.block.HangingWeb;
import com.github.amusingimpala75.lotr.block.HangingWebTypes;
import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.github.amusingimpala75.lotr.world.biomes.MirkwoodBiome;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MirkOakWebsDecorator extends TreeDecorator {
    public static Codec<MirkOakWebsDecorator> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.BOOL.fieldOf("mirkwoodOnly").forGetter(src -> src.mirkwoodOnly),
            Codec.FLOAT.fieldOf("probability").forGetter(src -> src.prob),
            Codec.FLOAT.fieldOf("perBlockChance").forGetter(src -> src.perBlockChance),
            Codec.FLOAT.fieldOf("doubleWebChance").forGetter(src -> src.doubleWebChance)
    ).apply(inst, inst.stable(MirkOakWebsDecorator::new)));
    private final boolean mirkwoodOnly;
    private final float prob;
    private final float perBlockChance;
    private final float doubleWebChance;
    public MirkOakWebsDecorator(boolean flag, float f, float perBlock, float doubleWeb) {
        this.mirkwoodOnly = flag;
        this.prob = f;
        this.perBlockChance = perBlock;
        this.doubleWebChance = doubleWeb;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return null;
    }

    @Override
    public void generate(StructureWorldAccess world, Random rand, List<BlockPos> trunk, List<BlockPos> leaves, Set<BlockPos> decoSet, BlockBox bb) {
        boolean doDecorate = rand.nextFloat() < this.prob;
        if (doDecorate && this.mirkwoodOnly) {
            BlockPos centralPos = new BlockPos((bb.minX + bb.maxX) / 2, bb.minY, (bb.minZ + bb.maxZ) / 2);
            //doDecorate &= world.getBiome(centralPos) instanceof MirkwoodBiome;        TODO:Check that works
            doDecorate &= ModBiomes.asLotrBiome(world.getBiome(centralPos)).getName().contains("mirkwood");
        }

        if (doDecorate) {
            Iterator var16 = leaves.iterator();

            while(true) {
                BlockPos webPos;
                do {
                    BlockPos leavesPos;
                    do {
                        if (!var16.hasNext()) {
                            return;
                        }

                        leavesPos = (BlockPos)var16.next();
                    } while(rand.nextFloat() >= this.perBlockChance);

                    webPos = leavesPos.down();
                } while(!world.isAir(webPos));

                BlockState baseWebState = ((Block)ModDefaultBiomeFeatures.getBlock("hanging_web")).getDefaultState();
                BlockPos belowWebPos = webPos.down();
                boolean placeDouble = rand.nextFloat() < this.doubleWebChance && world.isAir(belowWebPos);
                BlockState topWebState;
                if (placeDouble) {
                    topWebState = (BlockState)baseWebState.with(HangingWeb.TYPE, HangingWebTypes.DOUBLE_TOP);
                    BlockState bottomWebState = (BlockState)baseWebState.with(HangingWeb.TYPE, HangingWebTypes.DOUBLE_BOTTOM);
                    this.setBlockStateAndEncompassPosition(world, webPos, topWebState, decoSet, bb);
                    this.setBlockStateAndEncompassPosition(world, belowWebPos, bottomWebState, decoSet, bb);
                } else {
                    topWebState = (BlockState)baseWebState.with(HangingWeb.TYPE, HangingWebTypes.SINGLE);
                    this.setBlockStateAndEncompassPosition(world, webPos, topWebState, decoSet, bb);
                }

                world.getBlockState(webPos).updateNeighbors(world, webPos, 3);
            }
        }
    }
}
