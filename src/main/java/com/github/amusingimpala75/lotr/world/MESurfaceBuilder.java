package com.github.amusingimpala75.lotr.world;

import com.github.amusingimpala75.lotr.registry.ModBiomes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import java.util.Iterator;
import java.util.Random;

import static com.github.amusingimpala75.lotr.Lotr.*;

public class MESurfaceBuilder extends SurfaceBuilder<MESurfaceConfig> {
    public static final Codec<MESurfaceConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockState.CODEC.fieldOf("top_material").forGetter(source -> source.top),
            BlockState.CODEC.fieldOf("filler_material").forGetter(source -> source.bottom),
            BlockState.CODEC.fieldOf("underwater_material").forGetter(source -> source.underwater)
            ).apply(instance, instance.stable(MESurfaceConfig::new)));

    public MESurfaceBuilder(Codec<MESurfaceConfig> CODEC) {
        super(CODEC);
    }

    public static MESurfaceBuilder create() {
        return new MESurfaceBuilder(CODEC);
    }

    public void generate(Random rand, Chunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, MESurfaceConfig config) {
        int chunkX = x & 15;
        int chunkZ = z & 15;
        Mutable movingPos = new Mutable();
        BlockState top = config.getSurfaceReplacement(x, z, config.getTopMaterial(), true, rand);
        BlockState filler = config.getSurfaceReplacement(x, z, config.getUnderMaterial(), false, rand);
        BlockState underwater = config.getUnderwaterReplacement(x, z, config.getUnderwaterMaterial(), rand);
        int digDepth = -1;
        int soilDepth = (int)(noise * 0.25D + config.getFillerDepth() + rand.nextDouble() * 0.25D);
        if (soilDepth < 0) {
            soilDepth = 0;
        }

        int determinedTopTerrainY = -1;

        if (config.isRocky()) {
            int topBlock = startHeight - 1;
            movingPos.set(chunkX, topBlock, chunkZ);
            if (topBlock >= 90 && chunk.getBlockState(movingPos) == defaultBlock) {
                float hFactor = (float)(topBlock - 90) / 10.0F;
                float threshold = 0.6F - hFactor * 0.1F;
                threshold = Math.max(threshold, 0.0F);
                double rockyNoise = config.getNoiseFromFirst(x, z, 0.3D, 0.03D);
                if (rockyNoise > (double)threshold) {
                    if (rand.nextFloat() < 0.2F) {
                        top = Blocks.GRAVEL.getDefaultState();
                    } else {
                        top = Blocks.STONE.getDefaultState();
                    }

                    int prevTopBlock = topBlock;
                    if (rand.nextInt(20) == 0) {
                        topBlock++;
                    }

                    for(int i = topBlock; i >= prevTopBlock; i--) {
                        movingPos.set(chunkX, i, chunkZ);
                        chunk.setBlockState(movingPos, top, false);
                    }
                }
            }
        }

        if (config.hasPodzol() && !config.isMarsh()) {
            float podzolMinThreshold = 0.0F;
            boolean podzolHere = false;
            if (top.getBlock() == Blocks.GRASS_BLOCK) {
                float trees = 0.0F;
                if (ModBiomes.isLotrBiome(biome)) {
                    trees = ModBiomes.asLotrBiome(biome).getBiomeTreeAmount();
                }

                if (trees >= 1.5F) {
                    float threshold = 0.8F;
                    threshold -= trees * 0.15F;
                    threshold = Math.max(threshold, podzolMinThreshold);
                    double scale = 0.06D;
                    double randNoise = config.getNoiseFromSecond(x, z, (int) scale);    //TODO: POTENTIAL ISSUE WITH DOWNSIZE CAST
                    if (randNoise > (double)threshold) {
                        podzolHere = true;
                    }
                }
            }

            float pdzRand = rand.nextFloat();
            if (podzolHere) {
                if (pdzRand < 0.35F) {
                    top = Blocks.PODZOL.getDefaultState();
                } else if (pdzRand < 0.5F) {
                    top = Blocks.COARSE_DIRT.getDefaultState();
                } else if (pdzRand < 0.51F) {
                    top = Blocks.GRAVEL.getDefaultState();
                }
            }
        }

        if (config.isMarsh()) {
            double marshNoiseScale1 = 0.25D;
            double marshNoiseScale2 = 0.05D;
            double marshNoise= (MESurfaceConfig.MARSH_NOISE.sample((double)x * marshNoiseScale1, (double)z * marshNoiseScale1, false) + MESurfaceConfig.MARSH_NOISE.sample((double)x * marshNoiseScale2, (double)z * marshNoiseScale2, false)) / 2.0D;
            if (marshNoise > -0.1D) {
                for(int i  = startHeight; i >= 0; i--) {
                    movingPos.set(chunkX, i, chunkZ);
                    BlockState currentState = chunk.getBlockState(movingPos);
                    if (!currentState.isAir()) {
                        if (i == seaLevel - 1 && !currentState.getMaterial().isLiquid()) {
                            chunk.setBlockState(movingPos, Blocks.WATER.getDefaultState(), false);
                        }
                        break;
                    }
                }
            }
        }

        BlockState topToUse = top;
        BlockState fillerToUse = filler;
        Iterator<MESurfaceConfig.SubSoilLayer> subSoilLayers = config.getSubSoilLayers();

        for(int y = startHeight; y >= 0; y--) {
            movingPos.set(chunkX, y, chunkZ);
            BlockState currentState = chunk.getBlockState(movingPos);
            if (currentState.isAir()) {
                digDepth = -1;
            } else if (currentState.getBlock() == defaultBlock.getBlock()) {
                if (digDepth == -1) {
                    if (soilDepth < 0) {
                        topToUse = Blocks.AIR.getDefaultState();
                        fillerToUse = defaultBlock;
                    } else if (y >= seaLevel - 4 && y <= seaLevel + 1) {
                        topToUse = top;
                        fillerToUse = filler;
                    }

                    if (y < seaLevel && (topToUse == null || topToUse.isAir())) {
                        if (biome.getTemperature(movingPos.set(x, y, z)) < 0.15F) {
                            topToUse = Blocks.ICE.getDefaultState();
                        } else {
                            topToUse = defaultFluid;
                        }

                        movingPos.set(chunkX, y, chunkZ);
                    }

                    digDepth = soilDepth;
                    if (y >= seaLevel - 1) {
                        chunk.setBlockState(movingPos, topToUse, false);
                    } else if (y < seaLevel - 7 - soilDepth) {
                        topToUse = Blocks.AIR.getDefaultState();
                        fillerToUse = defaultBlock;
                        chunk.setBlockState(movingPos, underwater, false);
                    } else {
                        chunk.setBlockState(movingPos, fillerToUse, false);
                    }

                    if (determinedTopTerrainY == -1) {
                        determinedTopTerrainY = y;
                    }
                } else if (digDepth > 0) {
                    --digDepth;
                    chunk.setBlockState(movingPos, fillerToUse, false);
                } else if (digDepth == 0) {
                    if (subSoilLayers.hasNext()) {
                        MESurfaceConfig.SubSoilLayer subSoilLayer = (MESurfaceConfig.SubSoilLayer)subSoilLayers.next();
                        digDepth = subSoilLayer.getDepth(rand);
                        fillerToUse = subSoilLayer.getMaterial();
                    } else if (soilDepth > 1) {
                        if (fillerToUse.getBlock() == Blocks.SAND) {
                            digDepth = rand.nextInt(4) + Math.max(0, y - seaLevel);
                            fillerToUse = Blocks.SANDSTONE.getDefaultState();
                        } else if (fillerToUse.getBlock() == Blocks.RED_SAND) {
                            digDepth = rand.nextInt(4) + Math.max(0, y - seaLevel);
                            fillerToUse = Blocks.RED_SANDSTONE.getDefaultState();
                        } else if (fillerToUse.getBlock() == Registry.BLOCK.get(id("white_sand"))) {
                            digDepth = rand.nextInt(4) + Math.max(0, y - seaLevel);
                            fillerToUse = (Registry.BLOCK.get(id("white_sandstone"))).getDefaultState();
                        }
                    }

                    if (digDepth > 0) {
                        --digDepth;
                        chunk.setBlockState(movingPos, fillerToUse, false);
                    }
                }
            }
        }

        if (config.hasMountainTerrain()) {
            int rockDepth = (int)(noise * 6.0D + 2.0D + rand.nextDouble() * 0.25D);
            boolean passedTopBlock = false;

            for(int y = determinedTopTerrainY; y >= 0; --y) {
                movingPos.set(chunkX, y, chunkZ);
                BlockState currentState = chunk.getBlockState(movingPos);
                if (!currentState.getFluidState().isEmpty()) {
                    break;
                }

                if (!currentState.isAir()) {
                    boolean isTop = !passedTopBlock;
                    BlockState mountainBlock = config.getMountainReplacement(x, z, y, currentState, defaultBlock, isTop, y);
                    if (mountainBlock != currentState) {
                        chunk.setBlockState(movingPos, mountainBlock, false);
                    }

                    if (isTop && !passedTopBlock) {
                        passedTopBlock = true;
                    }
                }
            }
        }

    }
}
