package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.block.StrippedWoodHelper;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;

import java.util.*;
import java.util.function.Function;

public class PineStripDecorator extends TreeDecorator {
    public static Codec<PineStripDecorator> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            Codec.FLOAT.fieldOf("probability").forGetter(src -> src.prob),
            Codec.FLOAT.fieldOf("stripBegin").forGetter(src -> src.stripBegin),
            Codec.FLOAT.fieldOf("stripEnd").forGetter(src -> src.stripEnd)
    ).apply(inst, inst.stable(PineStripDecorator::new)));
    private final float prob;
    private final float stripBegin;
    private final float stripEnd;
    public PineStripDecorator(float prob, float stripBegin, float stripEnd) {
        this.prob = prob;
        this.stripBegin = stripBegin;
        this.stripEnd = stripEnd;
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return ModDefaultBiomeFeatures.PINE_STRIP;
    }

    @Override
    public void generate(StructureWorldAccess world, Random rand, List<BlockPos> trunk, List<BlockPos> leaves, Set<BlockPos> decoSet, BlockBox bb) {
        if (rand.nextFloat() < this.prob) {
            int trunkBase = ((BlockPos)trunk.get(0)).getY();
            int trunkHeight = trunk.size();
            int stripBeginY = Math.round((float)trunkHeight * this.stripBegin);
            int stripCompleteY = Math.round((float)trunkHeight * this.stripEnd);
            Function<Integer, Boolean> stripTest = (y) -> {
                int yRel = y - trunkBase;
                if (yRel < stripBeginY) {
                    return false;
                } else {
                    return yRel >= stripCompleteY ? true : rand.nextFloat() < (float)(yRel - stripBeginY + 1) / (float)(stripCompleteY - stripBeginY + 1);
                }
            };
            this.stripWood(world, trunk, stripTest, bb);
            this.stripWood(world, decoSet, stripTest, bb);
        }
    }
    private void stripWood(StructureWorldAccess world, Collection<BlockPos> posCollection, Function<Integer, Boolean> stripTest, BlockBox bb) {
        Set<BlockPos> temp = new HashSet();
        Iterator var6 = posCollection.iterator();

        while(var6.hasNext()) {
            BlockPos pos = (BlockPos)var6.next();
            int y = pos.getY();
            if ((Boolean)stripTest.apply(y)) {
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();
                Block stripped = (Block) StrippedWoodHelper.getStrippingMap().get(block);
                if (stripped != null) {
                    Property axis = PillarBlock.AXIS;
                    BlockState newState = (BlockState)stripped.getDefaultState().with(axis, state.get(axis));
                    this.setBlockStateAndEncompassPosition(world, pos, newState, temp, bb);
                }
            }
        }

    }
}
