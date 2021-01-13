package com.github.amusingimpala75.lotr.world.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.tree.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class PineBranchDecorator extends TreeDecorator {
    public static Codec<PineBranchDecorator> CODEC = RecordCodecBuilder.create(ins -> ins.group(
            BlockStateProvider.TYPE_CODEC.fieldOf("log").forGetter(src -> src.log),
            Codec.FLOAT.fieldOf("probability").forGetter(src -> src.probability)
    ).apply(ins, ins.stable(PineBranchDecorator::new)));
    private final BlockStateProvider log;
    private final float probability;
    public PineBranchDecorator(BlockStateProvider log, float probability) {
        this.probability = probability;
        this.log = log;
    }
    public PineBranchDecorator(BlockState log, float f) {
        this((BlockStateProvider)(new SimpleBlockStateProvider(log)), f);
    }
    @Override
    protected TreeDecoratorType<?> getType() {
        return ModDefaultBiomeFeatures.PINE_BRANCH;
    }

    @Override
    public void generate(StructureWorldAccess world, Random rand, List<BlockPos> trunk, List<BlockPos> leaves, Set<BlockPos> decoSet, BlockBox bb) {
        int baseY = ((BlockPos)trunk.get(0)).getY();
        int trunkHeight = trunk.size();
        Direction[] lastDir = new Direction[1];
        trunk.stream().filter((pos) -> {
            int diff = pos.getY() - baseY;
            return diff >= 3 && diff < trunkHeight - 3;
        }).forEach((pos) -> {
            if (rand.nextFloat() < this.probability) {
                Direction dir = Direction.Type.HORIZONTAL.random(rand);
                if (dir != lastDir[0]) {
                    lastDir[0] = dir;
                    BlockPos branchPos = pos.add(dir.getOffsetX(), 0, dir.getOffsetZ());
                    if (TreeFeature.isAir(world, branchPos)) {
                        BlockState blockstate = (BlockState)this.log.getBlockState(rand, branchPos).with(PillarBlock.AXIS, dir.getAxis());
                        this.setBlockStateAndEncompassPosition(world, branchPos, blockstate, decoSet, bb);
                    }
                }
            }

        });
    }
}
