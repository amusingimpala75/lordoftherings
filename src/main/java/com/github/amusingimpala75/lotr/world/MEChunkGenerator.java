package com.github.amusingimpala75.lotr.world;

import com.github.amusingimpala75.lotr.mixin.NoiseChunkGeneratorInvokers;
import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.google.common.collect.ImmutableList;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.*;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.*;

import java.util.List;
import java.util.function.Supplier;

/*
TODO: get general idea, rewrite, set for ME
 */
@SuppressWarnings("all")
public class MEChunkGenerator extends NoiseChunkGenerator {
    private final OctavePerlinNoiseSampler depthNoise;
    private final boolean isAmplified;
    private final int noiseSizeX;
    private final int noiseSizeY;
    private final int noiseSizeZ;
    private final int biomeSampleRadius;
    private final int biomeSampleWidth;
    private final float[] biomeHeightNoise;
    private final int riverSampleRadius;
    private final float[] riverSampleIndicator;

    public MEChunkGenerator(World worldIn, BiomeSource provider, MEGenSettings settings) {
        this(worldIn, provider, 4, 8, 256);
    }

    private MEChunkGenerator(World worldIn, BiomeSource provider, int hNoiseGran, int vNoiseGran, int height) {
        super(provider, 1, new Supplier<ChunkGeneratorSettings>() {     //TODO: HIGHLY QUESTIONABLE
            @Override
            public ChunkGeneratorSettings get() {
                return new MEGenSettings(new GenerationShapeConfig(256, new NoiseSamplingConfig(1.0D, 1.0D, 1.0D, 1.0D), new SlideConfig(1, 1, 0), new SlideConfig(1, 1, 0), 1, 1, 1.0D, 1.0D, true, false, true, false));
            }
        });
        this.random.consume(2620);
        this.depthNoise = new OctavePerlinNoiseSampler(this.random, ImmutableList.of(15, 0));
        this.isAmplified = false;
        this.noiseSizeX = 16 / hNoiseGran;
        this.noiseSizeY = height / vNoiseGran;
        this.noiseSizeZ = 16 / hNoiseGran;
        this.biomeSampleRadius = 6;
        this.biomeSampleWidth = this.biomeSampleRadius * 2 + 1;
        this.biomeHeightNoise = (float[])Util.make(new float[this.biomeSampleWidth * this.biomeSampleWidth], (array) -> {
            for(int z = -this.biomeSampleRadius; z <= this.biomeSampleRadius; ++z) {
                for(int x = -this.biomeSampleRadius; x <= this.biomeSampleRadius; ++x) {
                    float f = 10.0F / MathHelper.sqrt((float)(z * z + x * x) + 0.2F);
                    array[z + this.biomeSampleRadius + (x + this.biomeSampleRadius) * this.biomeSampleWidth] = f;
                }
            }

        });
        this.riverSampleRadius = 3;
        this.riverSampleIndicator = (float[])Util.make(new float[this.biomeSampleWidth * this.biomeSampleWidth], (array) -> {
            for(int z = -this.biomeSampleRadius; z <= this.biomeSampleRadius; ++z) {
                for(int x = -this.biomeSampleRadius; x <= this.biomeSampleRadius; ++x) {
                    float d = MathHelper.sqrt((float)(x * x + z * z));
                    float f = d <= (float)this.riverSampleRadius ? 1.0F : MathHelper.lerp((d - (float)this.riverSampleRadius) / (float)(this.biomeSampleRadius - this.riverSampleRadius), 1.0F, 0.0F);
                    if (f < 0.0F) {
                        f = 0.0F;
                    }

                    array[z + this.biomeSampleRadius + (x + this.biomeSampleRadius) * this.biomeSampleWidth] = f;
                }
            }

        });
    }

    @Override
    public void populateEntities(ChunkRegion region) {
        int i = region.getCenterChunkX();
        int j = region.getCenterChunkZ();
        Biome biome = region.getBiome((new ChunkPos(i, j)).getStartPos());
        ChunkRandom rand = new ChunkRandom();
        rand.setPopulationSeed(region.getSeed(), i << 4, j << 4);
        SpawnHelper.populateEntities(region, biome, i, j, rand);
    }

    public void sampleNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
        double coordScaleXZ = 484.412D;
        double coordScaleY = 1.0D;
        Biome biome = this.biomeSource.getBiomeForNoiseGen(noiseX, this.getMaxY(), noiseZ);
        double xzNoiseScale = ModBiomes.isLotrBiome(biome) ? (ModBiomes.asLotrBiome(biome)).getHorizontalNoiseScale() : (ModBiomes.biomes.get(0)).getHorizontalNoiseScale();
        double yNoiseScale = 5000.0D;
        double scaledNoiseXZ = coordScaleXZ / xzNoiseScale;
        double scaledNoiseY = coordScaleY / yNoiseScale;
        int i = -10;
        int j = 3;
        ((NoiseChunkGeneratorInvokers)this).invokeSampleNoiseColumn(noiseColumn, noiseX, noiseZ);
    }

    public double func_222545_a(double baseHeight, double heightVariation, int yIndex) {
        double heightStretch = 12.0D;
        double d0 = 8.5D;
        double d1 = ((double)yIndex - (8.5D + baseHeight * 8.5D / 8.0D * 4.0D)) * heightStretch * 128.0D / 256.0D / heightVariation;
        if (d1 < 0.0D) {
            d1 *= 4.0D;
        }

        return d1;
    }

    public double[] sampleNoiseColumn(int noiseX, int noiseZ) {
        double[] noise = new double[2];
        float totalScale = 0.0F;
        float totalDepth = 0.0F;
        float total = 0.0F;
        int i = 2;
        int j = this.getMaxY();
        float centralDepth = this.biomeSource.getBiomeForNoiseGen(noiseX, j, noiseZ).getDepth();

        float scaleSignificance;
        for(int k = -this.biomeSampleRadius; k <= this.biomeSampleRadius; ++k) {
            for(int l = -this.biomeSampleRadius; l <= this.biomeSampleRadius; ++l) {
                Biome biome = this.biomeSource.getBiomeForNoiseGen(noiseX + k, j, noiseZ + l);
                float depth = biome.getDepth();
                if (ModBiomes.isLotrBiome(biome)) {
                    scaleSignificance = (ModBiomes.asLotrBiome(biome)).getBiomeScaleSignificanceForChunkGen();
                } else {
                    scaleSignificance = 0.9F;
                }

                float scale = biome.getScale() * scaleSignificance + (1.0F - scaleSignificance);
                if (scale == 0.0F) {
                    scale = 1.0E-7F;
                }

                if (this.isAmplified && depth > 0.0F) {
                    depth = 1.0F + depth * 2.0F;
                    scale = 1.0F + scale * 4.0F;
                }

                int arrayIndex = k + this.biomeSampleRadius + (l + this.biomeSampleRadius) * this.biomeSampleWidth;
                float multiplier = this.biomeHeightNoise[arrayIndex] / (depth + 2.0F);
                if (biome.getDepth() > centralDepth) {
                    multiplier /= 2.0F;
                }

                if (ModBiomes.isLotrBiome(biome) && (ModBiomes.asLotrBiome(biome)).isRiver()) {
                    float affectingFactor = 5.0F;
                    if (centralDepth < 0.0F) {
                        affectingFactor *= 2.0F;
                    }

                    multiplier *= affectingFactor;
                }

                totalScale += scale * multiplier;
                totalDepth += depth * multiplier;
                total += multiplier;
            }
        }

        float avgScale = totalScale / total;
        float avgDepth = totalDepth / total;
        if (centralDepth < 0.0F && avgDepth >= 0.0F) {
            avgDepth = MathHelper.lerp(0.5F, avgDepth, centralDepth / 2.0F);
        }

        double randNoiseAdd = this.getNoiseDepthAt(noiseX, noiseZ);
        scaleSignificance = avgDepth;
        avgDepth = (float)((double)avgDepth + (randNoiseAdd * 8.0D + 1.0D) / 4.0D);
        if (scaleSignificance < 0.0F && avgDepth > scaleSignificance) {
            avgDepth = MathHelper.lerp(0.76F, avgDepth, scaleSignificance);
        }

        avgDepth = (avgDepth * 4.0F - 1.0F) / 8.0F;
        noise[0] = (double)avgDepth;
        noise[1] = (double)avgScale;
        return noise;
    }

    private double getNoiseDepthAt(int noiseX, int noiseZ) {
        double d0 = this.depthNoise.sample((double)(noiseX * 200), 10.0D, (double)(noiseZ * 200), 1.0D, 0.0D, true) * 65535.0D / 8000.0D;
        if (d0 < 0.0D) {
            d0 = -d0 * 0.3D;
        }

        d0 = d0 * 3.0D - 2.0D;
        if (d0 < 0.0D) {
            d0 /= 28.0D;
        } else {
            if (d0 > 1.0D) {
                d0 = 1.0D;
            }

            d0 /= 40.0D;
        }

        return d0;
    }

    @Override
    public List<SpawnSettings.SpawnEntry> getEntitySpawnList(Biome biome, StructureAccessor accessor, SpawnGroup creatureType, BlockPos pos) {
        return ModBiomes.isLotrBiome(biome) ? (ModBiomes.asLotrBiome(biome)).getSpawnsAtLocation(creatureType) : biome.getSpawnSettings().getSpawnEntry(creatureType);
    }

    public void func_203222_a(ServerWorld world, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
    }

    @Override
    public int getSpawnHeight() {
        return this.getSeaLevel() + 1;
    }

    @Override
    public int getSeaLevel() {
        return 63;
    }
}
