package com.github.amusingimpala75.lotr.world.features.config;

import com.google.common.collect.Lists;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.List;

public class DeadTreeFeatureConfig extends TreeFeatureConfig {

    public final BlockStateProvider woodProvider;
    public final int heightRandA;
    public final int heightRandB;

    protected DeadTreeFeatureConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, FoliagePlacer foliagePlacer, TrunkPlacer trunkPlacer, FeatureSize minimumSize, List<TreeDecorator> decorators, int maxWaterDepth, boolean ignoreVines, Heightmap.Type heightmap, BlockStateProvider woodProvider, int heightRandA, int heightRandB) {
        super(trunkProvider, leavesProvider, foliagePlacer, trunkPlacer, minimumSize, decorators, maxWaterDepth, ignoreVines, heightmap);
        this.heightRandA = heightRandA;
        this.heightRandB = heightRandB;
        this.woodProvider = woodProvider;
    }
    public static class Builder extends net.minecraft.world.gen.feature.TreeFeatureConfig.Builder {
        private final BlockStateProvider woodProvider;
        private List<TreeDecorator> decorators = Lists.newArrayList();
        private int baseHeight;
        private int heightRandA;
        private int heightRandB;
        private FoliagePlacer foliagePlacer;
        private TrunkPlacer trunkPlacer;
        private FeatureSize size;
        private int maxWaterDepth;
        private boolean ignoreVines;
        private Heightmap.Type heightmap;

        public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProvider, FoliagePlacer foliagePlacer, TrunkPlacer trunkPlacer, FeatureSize size, BlockStateProvider woodProviderIn) {
            super(trunkProviderIn, leavesProvider, foliagePlacer, trunkPlacer, size);
            this.woodProvider = woodProviderIn;
            this.foliagePlacer = foliagePlacer;
            this.trunkPlacer = trunkPlacer;
            this.size = size;
        }

        public DeadTreeFeatureConfig.Builder decorators(List<TreeDecorator> decs) {
            this.decorators = decs;
            return this;
        }

        public DeadTreeFeatureConfig.Builder baseHeight(int h) {
            this.baseHeight = h;
            return this;
        }

        public DeadTreeFeatureConfig.Builder heightRandA(int a) {
            this.heightRandA = a;
            return this;
        }

        public DeadTreeFeatureConfig.Builder heightRandB(int b) {
            this.heightRandB = b;
            return this;
        }
        public TreeFeatureConfig.Builder maxWaterDepth(int maxWaterDepth) {
            this.maxWaterDepth = maxWaterDepth;
            return this;
        }

        public TreeFeatureConfig.Builder ignoreVines() {
            this.ignoreVines = true;
            return this;
        }

        public TreeFeatureConfig.Builder heightmap(Heightmap.Type heightmap) {
            this.heightmap = heightmap;
            return this;
        }

        public DeadTreeFeatureConfig build() {
            return new DeadTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.foliagePlacer, this.trunkPlacer, this.size, this.decorators, /*this.baseHeight,*/this.maxWaterDepth, this.ignoreVines, this.heightmap, this.woodProvider, this.heightRandA, this.heightRandB);
        }
    }
}
