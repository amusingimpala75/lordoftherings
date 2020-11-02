package com.github.amusingimpala75.lotr.world;

import java.util.List;
import java.util.Random;
//import lotr.common.init.LOTRBiomes;
//import lotr.common.world.biome.LOTRBiomeBase;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.server.world.ServerWorld;
/**///import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.util.math.noise.OctavePerlinNoiseSampler;
import net.minecraft.world.ChunkRegion;
import net.minecraft.server.world.ServerWorld;
/**///import net.minecraft.world.spawner.WorldEntitySpawner;



public class MEChunkGenerator/* extends NoiseChunkGenerator<MiddleEarthGenSettings>*/ {
      /*private final OctavePerlinNoiseSampler depthNoise;
      private final boolean isAmplified;
      private final int noiseSizeX;
      private final int noiseSizeY;
      private final int noiseSizeZ;
    
      public MiddleEarthChunkGenerator(WorldAccess worldIn, BiomeSource provider, MiddleEarthGenSettings settings) {
             this(worldIn, provider, 4, 8, 256, settings);
      }
      private final int biomeSampleRadius; private final int biomeSampleWidth; private final float[] biomeHeightNoise; private final int riverSampleRadius;
      private final float[] riverSampleIndicator;
    
      private MiddleEarthChunkGenerator(WorldAccess worldIn, BiomeSource provider, int hNoiseGran, int vNoiseGran, int height, MiddleEarthGenSettings settings) {
             super(worldIn, provider, hNoiseGran, vNoiseGran, height, settings, true);
             this.field_222558_e.func_202423_a(2620);
             this.depthNoise = new OctavePerlinNoiseSampler(this.field_222558_e, 15, 0);
             this.isAmplified = false;
             this.noiseSizeX = 16 / hNoiseGran;
             this.noiseSizeY = height / vNoiseGran;
             this.noiseSizeZ = 16 / hNoiseGran;
        
             this.biomeSampleRadius = 6;
             this.biomeSampleWidth = this.biomeSampleRadius * 2 + 1;
             this.biomeHeightNoise = (float[])Util.make(new float[this.biomeSampleWidth * this.biomeSampleWidth], array -> {
                      for (int z = -this.biomeSampleRadius; z <= this.biomeSampleRadius; z++) {
                            for (int x = -this.biomeSampleRadius; x <= this.biomeSampleRadius; x++) {
                                  float f = 10.0F / MathHelper.sqrt((z * z + x * x) + 0.2F);
                    
                    
                                  array[z + this.biomeSampleRadius + (x + this.biomeSampleRadius) * this.biomeSampleWidth] = f;
                            }
                      }
             });
        
        
             this.riverSampleRadius = 3;
             this.riverSampleIndicator = (float[])Util.make(new float[this.biomeSampleWidth * this.biomeSampleWidth], array -> {
                      for (int z = -this.biomeSampleRadius; z <= this.biomeSampleRadius; z++) {
                            for (int x = -this.biomeSampleRadius; x <= this.biomeSampleRadius; x++) {
                                  float d = MathHelper.sqrt((x * x + z * z));
                                  float f = (d <= this.riverSampleRadius) ? 1.0F : MathHelper.lerp((d - this.riverSampleRadius) / (this.biomeSampleRadius - this.riverSampleRadius), 1.0F, 0.0F);
                                  if (f < 0.0F) {
                                        f = 0.0F;
                                  }
                                  array[z + this.biomeSampleRadius + (x + this.biomeSampleRadius) * this.biomeSampleWidth] = f;
                            }
                      }
             });
      }
    
      public void func_202093_c(ChunkRegion region) {
             int i = region.getCenterChunkX();
             int j = region.getCenterChunkZ();
             Biome biome = region.getBiome((new ChunkPos(i, j)).getStartPos());
             SharedSeedRandom rand = new SharedSeedRandom();
             rand.setDecorationSeed(region.getSeed(), i << 4, j << 4);
        
             WorldEntitySpawner.func_77191_a((WorldAccess)region, biome, i, j, (Random)rand);
      }
    
    
    
      protected void func_222548_a(double[] noiseColumn, int noiseX, int noiseZ) {
             double coordScaleXZ = 484.412D;
             double coordScaleY = 1.0D;

             Biome biome = this.biomeSource.getBiomeForNoiseGen(noiseX, func_222530_f(), noiseZ);
             double xzNoiseScale = (biome instanceof LOTRBiomeBase) ? ((LOTRBiomeBase)biome).getHorizontalNoiseScale() : ((LOTRBiomeBase)LOTRBiomes.SHIRE.get()).getHorizontalNoiseScale();
             double yNoiseScale = 5000.0D;
        
             double scaledNoiseXZ = coordScaleXZ / xzNoiseScale;
             double scaledNoiseY = coordScaleY / yNoiseScale;

             int i = -10;
             int j = 3;
             func_222546_a(noiseColumn, noiseX, noiseZ, coordScaleXZ, coordScaleY, scaledNoiseXZ, scaledNoiseY, 3, -10);
      }
    
    
    
      protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
             double heightStretch = 12.0D;
             double d0 = 8.5D;
             double d1 = (p_222545_5_ - 8.5D + p_222545_1_ * 8.5D / 8.0D * 4.0D) * heightStretch * 128.0D / 256.0D / p_222545_3_;
             if (d1 < 0.0D) {
                 d1 *= 4.0D;
             }
             return d1;
      }
    
    
      protected double[] func_222549_a(int noiseX, int noiseZ) {
          double[] noise = new double[2];
          float totalScale = 0.0F;
          float totalDepth = 0.0F;
          float total = 0.0F;
          int i = 2;
          int j = func_222530_f();
          float centralDepth = this.biomeSource.getBiomeForNoiseGen(noiseX, j, noiseZ).getDepth();
        
          for (int k = -this.biomeSampleRadius; k <= this.biomeSampleRadius; k++) {
            
              for (int l = -this.biomeSampleRadius; l <= this.biomeSampleRadius; l++) {

                  Biome biome = this.biomeSource.getBiomeForNoiseGen(noiseX + k, j, noiseZ + l);
                  float depth = biome.getDepth();
                  float scale = biome.getScale();

                  if (this.isAmplified && depth > 0.0F) {
                    
                      depth = 1.0F + depth * 2.0F;
                      scale = 1.0F + scale * 4.0F;

                  }

                  int arrayIndex = k + this.biomeSampleRadius + (l + this.biomeSampleRadius) * this.biomeSampleWidth;
                  float multiplier = this.biomeHeightNoise[arrayIndex] / (depth + 2.0F);

                  if (biome.getDepth() > centralDepth) {
                      multiplier /= 2.0F;
                  }
                
                  if (biome instanceof LOTRBiomeBase && ((LOTRBiomeBase)biome).isRiver()) {
                    
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
        
          double randNoiseAdd = getNoiseDepthAt(noiseX, noiseZ);
          float avgDepthBeforeNoise = avgDepth;
          avgDepth = (float)(avgDepth + (randNoiseAdd * 8.0D + 1.0D) / 4.0D);
        
          if (avgDepthBeforeNoise < 0.0F && avgDepth > avgDepthBeforeNoise) {
              avgDepth = MathHelper.lerp(0.76F, avgDepth, avgDepthBeforeNoise);
          }
        
          avgScale = avgScale * 0.9F + 0.1F;
          avgDepth = (avgDepth * 4.0F - 1.0F) / 8.0F;
          noise[0] = avgDepth;
          noise[1] = avgScale;
          return noise;
      }
    
    
      private double getNoiseDepthAt(int noiseX, int noiseZ) {
          double d0 = this.depthNoise.sample((noiseX * 200), 10.0D, (noiseZ * 200), 1.0D, 0.0D, true) * 65535.0D / 8000.0D;

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
    
    
    
      public List<Biome.SpawnListEntry> func_177458_a(SpawnGroup creatureType, BlockPos pos) {
          Biome biome = this.field_222540_a.func_226691_t_(pos);
          if (biome instanceof LOTRBiomeBase) {
              return ((LOTRBiomeBase)biome).getSpawnsAtLocation(creatureType, this.field_222540_a, pos);
          }
          return super.func_177458_a(creatureType, pos);
      }

      public void func_203222_a(ServerWorld world, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {}

      public int func_205470_d() {
          return this.field_222540_a.func_181545_F() + 1;
      }

      public int func_222530_f() {
          return 63;
      }*/
}