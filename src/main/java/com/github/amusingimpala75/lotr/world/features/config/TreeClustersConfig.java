package com.github.amusingimpala75.lotr.world.features.config;

import com.github.amusingimpala75.lotr.world.features.TreeCluster;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.decorator.DecoratorConfig;

public class TreeClustersConfig implements DecoratorConfig {
    public static Codec<TreeClustersConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("count").forGetter(source -> source.count),
            Codec.FLOAT.fieldOf("extraChance").forGetter(source -> source.extraChance),
            Codec.INT.fieldOf("extraCount").forGetter(source -> source.extraCount),
            Codec.INT.fieldOf("clusterScale").forGetter(source -> source.clusterScale),
            Codec.INT.fieldOf("clusterChance").forGetter(source -> source.clusterChance),
            Codec.INT.fieldOf("clusterExtraCount").forGetter(source -> source.clusterExtraCount),
            Codec.INT.fieldOf("clusterRandomExtraCount").forGetter(source -> source.clusterRandomExtraCount),
            Codec.INT.fieldOf("layerLimit").forGetter(source -> source.layerLimit),
            Codec.BOOL.fieldOf("isLayerUpperLimit").forGetter(source -> source.isLayerUpperLimit)
            ).apply(instance, instance.stable(TreeClustersConfig::new)));
    public final int count;
    public final float extraChance;
    public final int extraCount;
    public final int clusterScale;
    public final int clusterChance;
    public final int clusterExtraCount;
    public final int clusterRandomExtraCount;
    public final int layerLimit;
    public final boolean isLayerUpperLimit;

    public static TreeClustersConfig noClusters(int count, float extraChance, int extraCount) {
        return withNormalClusters(count, extraChance, extraCount, 0, -1);
    }

    public static TreeClustersConfig belowTreelineNoClusters(int count, float extraChance, int extraCount, int treeline) {
        return belowTreelineWithNormalClusters(count, extraChance, extraCount, 0, -1, treeline);
    }

    public static TreeClustersConfig aboveTreelineNoClusters(int count, float extraChance, int extraCount, int treeline) {
        return aboveTreelineWithNormalClusters(count, extraChance, extraCount, 0, -1, treeline);
    }

    public static TreeClustersConfig withNormalClusters(int count, float extraChance, int extraCount, int clusterScale, int clusterChance) {
        return create(count, extraChance, extraCount, clusterScale, clusterChance, 6, 4, -1, false);
    }

    public static TreeClustersConfig belowTreelineWithNormalClusters(int count, float extraChance, int extraCount, int clusterScale, int clusterChance, int treeline) {
        return create(count, extraChance, extraCount, clusterScale, clusterChance, 6, 4, treeline, true);
    }

    public static TreeClustersConfig aboveTreelineWithNormalClusters(int count, float extraChance, int extraCount, int clusterScale, int clusterChance, int treeline) {
        return create(count, extraChance, extraCount, clusterScale, clusterChance, 6, 4, treeline, false);
    }

    public static TreeClustersConfig create(int count, float extraChance, int extraCount, int clusterScale, int clusterChance, int clusterExtraCount, int clusterRandomExtraCount, int layerLimit, boolean isLayerUpperLimit) {
        return new TreeClustersConfig(count, extraChance, extraCount, clusterScale, clusterChance, clusterExtraCount, clusterRandomExtraCount, layerLimit, isLayerUpperLimit);
    }

    private TreeClustersConfig(int count, float extraChance, int extraCount, int clusterScale, int clusterChance, int clusterExtraCount, int clusterRandomExtraCount, int layerLimit, boolean isLayerUpperLimit) {
        this.count = count;
        this.extraChance = extraChance;
        this.extraCount = extraCount;
        this.clusterScale = clusterScale;
        this.clusterChance = clusterChance;
        this.clusterExtraCount = clusterExtraCount;
        this.clusterRandomExtraCount = clusterRandomExtraCount;
        this.layerLimit = layerLimit;
        this.isLayerUpperLimit = isLayerUpperLimit;
    }

    public <T> Dynamic<T> func_214719_a(DynamicOps<T> ops) {
        ImmutableMap.Builder<T, T> builder = ImmutableMap.builder();
        builder.put(ops.createString("count"), ops.createInt(this.count)).put(ops.createString("extra_chance"), ops.createFloat(this.extraChance)).put(ops.createString("extra_count"), ops.createInt(this.extraCount)).put(ops.createString("cluster_scale"), ops.createInt(this.clusterScale)).put(ops.createString("cluster_chance"), ops.createInt(this.clusterChance)).put(ops.createString("cluster_extra_count"), ops.createInt(this.clusterExtraCount)).put(ops.createString("cluster_random_extra_count"), ops.createInt(this.clusterRandomExtraCount)).put(ops.createString("layer_limit"), ops.createInt(this.layerLimit)).put(ops.createString("is_layer_upper_limit"), ops.createBoolean(this.isLayerUpperLimit));
        return new Dynamic(ops, ops.createMap(builder.build()));
    }

    public static TreeClustersConfig deserialize(Dynamic<?> dyn) {
        int count = dyn.get("count").asInt(0);
        float extraChance = dyn.get("extra_chance").asFloat(0.0F);
        int extraCount = dyn.get("extra_count").asInt(0);
        int clusterScale = dyn.get("cluster_scale").asInt(0);
        int clusterChance = dyn.get("cluster_chance").asInt(-1);
        int clusterExtraCount = dyn.get("cluster_extra_count").asInt(6);
        int clusterRandomExtraCount = dyn.get("cluster_random_extra_count").asInt(4);
        int layerLimit = dyn.get("layer_limit").asInt(-1);
        boolean isLayerUpperLimit = dyn.get("is_layer_upper_limit").asBoolean(false);
        return new TreeClustersConfig(count, extraChance, extraCount, clusterScale, clusterChance, clusterExtraCount, clusterRandomExtraCount, layerLimit, isLayerUpperLimit);
    }
}
