package com.github.amusingimpala75.lotr.world.features;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.OptionalDynamic;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class WeightedFeature<F extends ConfiguredFeature> {
    public static Codec<WeightedFeature<?>> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ConfiguredFeature.CODEC.fieldOf("feature").forGetter(source -> source.feature),
            Codec.INT.fieldOf("weight").forGetter(source -> source.weight)
    ).apply(instance, instance.stable(WeightedFeature::new)));
    public final F feature;
    public final int weight;

    private WeightedFeature(F f, int w) {
        this.feature = f;
        this.weight = w;
    }

    public static <F extends ConfiguredFeature> WeightedFeature<F> make(F f, int w) {
        return new WeightedFeature(f, w);
    }

    /*public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        Dynamic<T> d_feature = this.feature.func_222735_a(ops);
        Dynamic<T> d_weight = new Dynamic(ops, ops.createMap(ImmutableMap.of(ops.createString("weight"), ops.createInt(this.weight))));
        OptionalDynamic<T> merged = d_feature.merge(d_weight);
        return merged.orElseEmptyList();        //TODO: Does Fix?
        //return d_feature.merge(d_weight);
    }

    public static <T> WeightedFeature<?> deserialize(Dynamic<T> dyn) {
        return new WeightedFeature(ConfiguredFeature.func_222736_a(dyn), dyn.get("weight").asInt(0));
    }*/
}
