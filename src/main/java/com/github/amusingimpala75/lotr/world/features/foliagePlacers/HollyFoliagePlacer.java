package com.github.amusingimpala75.lotr.world.features.foliagePlacers;

import com.github.amusingimpala75.lotr.mixin.UniformIntDistributionAccessor;
import com.github.amusingimpala75.lotr.world.features.ModDefaultBiomeFeatures;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class HollyFoliagePlacer extends FoliagePlacer {
    public static Codec<HollyFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            UniformIntDistribution.CODEC.fieldOf("radius").forGetter(source -> source.radius),
            UniformIntDistribution.CODEC.fieldOf("offset").forGetter(source -> source.offset)
    ).apply(instance, instance.stable(HollyFoliagePlacer::new)));

    public HollyFoliagePlacer(UniformIntDistribution radius, UniformIntDistribution offset) {
        super(radius, offset);
    }
    //public HollyFoliagePlacer(int r, int rRand) {
    //    super(r, rRand, LOTRFoliagePlacers.HOLLY_FOLIAGE);
    //}

    //public <T> HollyFoliagePlacer(Dynamic<T> dyn) {
    //    this(dyn.get("radius").asInt(0), dyn.get("radius_random").asInt(0));
    //}

    public void func_225571_a_(ModifiableTestableWorld world, Random rand, TreeFeatureConfig config, int leafTop, int leafBottom, int maxLeafWidth, BlockPos base, Set<BlockPos> leaves) {
        int layerWidth = 0;
        for (int y = leafTop; y >= leafBottom; y--) {
            if (y == leafTop) {
                layerWidth = 0;
            }
            else if (y >= leafTop - 2 || y == leafBottom) {
                layerWidth = 1;
            } else {
                layerWidth = maxLeafWidth;
            }
            this.func_227384_a_(world, rand, config, leafTop, base, y, layerWidth, leaves);
        }

    }

    public int func_225573_a_(Random rand, int leafBottom, int leafTop, TreeFeatureConfig config) {
        return ((UniformIntDistributionAccessor)this.radius).getBase() + rand.nextInt(((UniformIntDistributionAccessor)this.offset).getBase() + 1);
    }

    protected boolean func_225572_a_(Random rand, int leafTopY, int x, int currentLayerY, int z, int layerWidth) {
        if (layerWidth > 0) {
            int yRel = leafTopY - currentLayerY;
            if (yRel % 2 == 1) {
                return Math.abs(x) == layerWidth && Math.abs(z) == layerWidth;
            }
        }

        return false;
    }

    public int func_225570_a_(int leafBottom, int leafTop, int maxLeafWidth, int y) {
        return y <= leafBottom ? 0 : maxLeafWidth;
    }
    protected void func_227384_a_(ModifiableTestableWorld arg, Random random, TreeFeatureConfig arg2, int i, BlockPos arg3, int j, int k, Set<BlockPos> set) {
        BlockPos.Mutable lv = new BlockPos.Mutable();
        for (int l = -k; l <= k; l++) {
            for (int m = -k; m <= k; m++) {
                if (!isInvalidForLeaves(random, i, l, j, m, k==2)) {
                    lv.set(l + arg3.getX(), j + arg3.getY(), m + arg3.getZ());
                    method_23450(arg, random, (BlockPos)lv, arg2, set);
                }
            }
        }
    }

    protected void method_23450(ModifiableTestableWorld arg, Random random, BlockPos arg2, TreeFeatureConfig arg3, Set<BlockPos> set) {
        if (TreeFeature.isAirOrLeaves((TestableWorld)arg, arg2) || TreeFeature.canReplace(arg, arg2) /*|| AbstractTreeFeature.isWater((TestableWorld)arg, arg2)*/) {
            arg.setBlockState(arg2, arg3.leavesProvider.getBlockState(random, arg2), 19);
            set.add(arg2.toImmutable());
        }
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModDefaultBiomeFeatures.HOLLY_FOLIAGE;
    }

    @Override
    protected void generate(ModifiableTestableWorld world, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, Set<BlockPos> leaves, int offset, BlockBox box) {
        func_225571_a_(world, random, config, foliageHeight+offset, foliageHeight, radius, new BlockPos(box.getCenter().getX(), box.getCenter().getY(), box.getCenter().getZ()), leaves);
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return func_225573_a_(random, trunkHeight, trunkHeight, config);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int baseHeight, int dx, int dy, int dz, boolean giantTrunk) {
        return func_225572_a_(random, baseHeight, dx, dy, dz, giantTrunk ? 2 : 1);
    }
}
