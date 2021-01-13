package com.github.amusingimpala75.lotr.world.features.config;

import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.FeatureSize;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.tree.TreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.List;

public class ExtendedTreeConfig extends TreeFeatureConfig {
    public final BlockStateProvider woodProvider;
    public final boolean isMirky;
    public final BlockStateProvider strippedLogProvider;

    protected ExtendedTreeConfig(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, FoliagePlacer foliagePlacer, TrunkPlacer trunkPlacer, FeatureSize minimumSize, List<TreeDecorator> decorators, int maxWaterDepth, boolean ignoreVines, Heightmap.Type heightmap, BlockStateProvider strippedLogProvider, BlockStateProvider woodProvider, boolean isMirky) {
        super(trunkProvider, leavesProvider, foliagePlacer, trunkPlacer, minimumSize, decorators, maxWaterDepth, ignoreVines, heightmap);
        this.woodProvider = woodProvider;
        this.isMirky = isMirky;
        this.strippedLogProvider = strippedLogProvider;
    }
    protected ExtendedTreeConfig(TreeFeatureConfig config, BlockStateProvider woodProvider, boolean isMirky, BlockStateProvider strippedLogProvider) {
        super(config.trunkProvider, config.leavesProvider, config.foliagePlacer, config.trunkPlacer, config.minimumSize, config.decorators, config.maxWaterDepth, config.ignoreVines, config.heightmap);
        this.strippedLogProvider = strippedLogProvider;
        this.isMirky = isMirky;
        this.woodProvider = woodProvider;
    }

    public static class Builder extends TreeFeatureConfig.Builder {
        boolean isMirky;
        BlockStateProvider strippedLogProvider;
        BlockStateProvider woodProvider;
        public Builder(BlockStateProvider trunkProvider, BlockStateProvider leavesProvider, FoliagePlacer foliagePlacer, TrunkPlacer trunkPlacer, FeatureSize minimumSize) {
            super(trunkProvider, leavesProvider, foliagePlacer, trunkPlacer, minimumSize);
        }
        public ExtendedTreeConfig.Builder isMirky(boolean flag) {
            this.isMirky = flag;
            return this;
        }

        public ExtendedTreeConfig.Builder strippedLog(BlockStateProvider strippedLog) {
            this.strippedLogProvider = strippedLog;
            return this;
        }
        public ExtendedTreeConfig.Builder woodProvider(BlockStateProvider woodProvider) {
            this.woodProvider = woodProvider;
            return this;
        }
        public ExtendedTreeConfig build() {
            return new ExtendedTreeConfig(super.build(), this.woodProvider, this.isMirky, this.strippedLogProvider);
        }
    }
}
