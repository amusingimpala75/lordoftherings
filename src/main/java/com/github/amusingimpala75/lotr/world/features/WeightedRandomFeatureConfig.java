package com.github.amusingimpala75.lotr.world.features;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressWarnings({"unchecked"})
public class WeightedRandomFeatureConfig implements FeatureConfig {
    public static Codec<WeightedRandomFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            WeightedFeature.CODEC.listOf().fieldOf("features").forGetter(source -> source.weightedFeatures)
    ).apply(instance, instance.stable(WeightedRandomFeatureConfig::new)));
    public final List<WeightedFeature<?>> weightedFeatures;
    private int totalWeight;

    public static WeightedRandomFeatureConfig fromEntries(Object... entries) {
        try {
            List<WeightedFeature<?>> tempList = new ArrayList();

            for (int i = 0; i < entries.length; i += 2) {
                ConfiguredFeature feature = (ConfiguredFeature) entries[i];
                int weight = (Integer) entries[i + 1];
                WeightedFeature wf = WeightedFeature.make(feature, weight);
                tempList.add(wf);
            }

            return new WeightedRandomFeatureConfig(ImmutableList.copyOf(tempList));
        } catch (ArrayIndexOutOfBoundsException | ClassCastException var6) {
            throw new IllegalArgumentException("Error adding biome trees! A list of (tree1, weight1), (tree2, weight2)... is required", var6);
        }
    }

    public WeightedRandomFeatureConfig(List<WeightedFeature<?>> features) {
        this.weightedFeatures = features;
        this.updateTotalWeight();
    }

    private void updateTotalWeight() {
        this.totalWeight = 0;
        this.weightedFeatures.stream().forEach((wf) -> {
            this.totalWeight += wf.weight;
        });
    }

    private int getTotalWeight() {
        return this.totalWeight;
    }

    public <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, F> getRandomFeature(Random rand) {
        int totalWeight = this.getTotalWeight();
        int chosenWeight = rand.nextInt(totalWeight);
        WeightedFeature selected = null;

        float featureWeight;
        for (Iterator var5 = this.weightedFeatures.iterator(); var5.hasNext(); chosenWeight = (int) ((float) chosenWeight - featureWeight)) {
            WeightedFeature<?> weightedFeature = (WeightedFeature) var5.next();
            featureWeight = (float) weightedFeature.weight;
            if ((float) chosenWeight < featureWeight) {
                selected = weightedFeature;
                break;
            }
        }

        if (selected == null) {
            LogManager.getLogger().error("WeightedRandomFeature error: total weight = %d, chosen weight = %d, but selected feature == null", totalWeight, chosenWeight);
        }

        return selected.feature;
    }

    /*public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        T t = ops.createList(this.weightedFeatures.stream().map((wf) -> {
            return wf.serialize(ops).getValue();
        }));
        return new Dynamic(ops, ops.createMap(ImmutableMap.of(ops.createString("features"), t)));
    }

    public static <T> WeightedRandomFeatureConfig deserialize(Dynamic<T> dyn) {
        List<WeightedFeature<?>> list = dyn.get("features").asList(WeightedFeature::deserialize);
        return new WeightedRandomFeatureConfig(list);

    }*/
}