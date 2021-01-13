package com.github.amusingimpala75.lotr.world;

import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.awt.*;
import java.util.Map;
import java.util.Set;

import static com.github.amusingimpala75.lotr.Lotr.*;
/*
TODO: de-blockify biome boundaries;
 */
public class MiddleEarthBiomeSource extends BiomeSource {
    public static final Codec<MiddleEarthBiomeSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter(source -> source.biomeRegistry),
            Codec.LONG.fieldOf("seed").stable().forGetter(source -> source.seed))
            .apply(instance, instance.stable(MiddleEarthBiomeSource::new)));
    public long seed;
    public Registry<Biome> biomeRegistry;
    public int xOffset = 810;
    public int zOffset = 730;
    public static Set<Map.Entry<RegistryKey<Biome>, Biome>> biomes = BuiltinRegistries.BIOME.getEntries();

    public MiddleEarthBiomeSource(Registry<Biome> biomes, long seed) {
        super(ImmutableList.of());
        this.seed = seed;
        this.biomeRegistry = biomes;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new MiddleEarthBiomeSource(this.biomeRegistry, seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        int biomeX2 = new Integer(biomeX);
        int biomeZ2 =  new Integer(biomeZ);
        biomeX2 = biomeX2/8;
        biomeZ2 = biomeZ2/8;
        if ((0 <= biomeX2 + xOffset) && ( biomeX2 + xOffset < (ModBiomes.mapImage.getWidth()))) {
            if ((0 <= biomeZ2 + (zOffset)) && (biomeZ2 + (zOffset) < (ModBiomes.mapImage.getHeight()))) {
                Color biomeColor = new Color(ModBiomes.mapImage.getRGB(biomeX2 + xOffset, biomeZ2 + zOffset), true);
                int color = biomeColor.getRGB() & 16777215;
                return biomeRegistry.get(ModBiomes.fromMapColor(color));
            }
        }
        return biomeRegistry.get(id("river"));
    }
}
