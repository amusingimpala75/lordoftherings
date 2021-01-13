package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.TreeClustersConfig;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TreeClusters extends Decorator<TreeClustersConfig> {
    private static final Random CLUSTER_RAND = new Random(2353233561358230584L);

    public TreeClusters(Codec<TreeClustersConfig> codec) {
        super(codec);
    }

    public Stream<BlockPos> getPositions(/*ServerWorldAccess world, ChunkGenerator<? extends GenerationSettings> generator,*/DecoratorContext context, Random rand, TreeClustersConfig config, BlockPos pos) {
        int numPositions = config.count;
        if (rand.nextFloat() < config.extraChance) {
            numPositions += config.extraCount;
        }

        float reciprocalTreeFactor = 1.0F;
        int cluster = Math.round((float)config.clusterChance * reciprocalTreeFactor);
        if (cluster > 0) {
            long seed = (long)(pos.getX() / config.clusterScale * 3129871) ^ (long)(pos.getZ() / config.clusterScale) * 116129781L;
            seed = seed * seed * 42317861L + seed * 11L;
            CLUSTER_RAND.setSeed(seed);
            if (CLUSTER_RAND.nextInt(cluster) == 0) {
                numPositions += config.clusterExtraCount + rand.nextInt(config.clusterRandomExtraCount + 1);
            }
        }

        Stream<BlockPos> positions = IntStream.range(0, numPositions).mapToObj((index) -> {
            int x = rand.nextInt(16) + pos.getX();
            int z = rand.nextInt(16) + pos.getZ();
            int y = context.getTopY(Heightmap.Type.MOTION_BLOCKING, x, z);
            return new BlockPos(x, y, z);
        });
        if (config.layerLimit >= 0) {
            positions = positions.filter((aPos) -> {
                if (config.isLayerUpperLimit) {
                    return aPos.getY() <= config.layerLimit;
                } else {
                    return aPos.getY() >= config.layerLimit;
                }
            });
        }

        return positions;
    }
}
