package com.github.amusingimpala75.lotr.world.features;

import com.github.amusingimpala75.lotr.world.features.config.CobwebFeatureConfig;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class CobwebFeature extends Feature<CobwebFeatureConfig> {
    public CobwebFeature(Codec<CobwebFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(StructureWorldAccess world, ChunkGenerator/*<? extends GenerationSettings>*/ generator, Random rand, BlockPos pos, CobwebFeatureConfig config) {
        BlockPos.Mutable movingPos = new BlockPos.Mutable();
        BlockPos.Mutable adjPos = new BlockPos.Mutable();

        for(int l = 0; l < config.tries; ++l) {
            int x = pos.getX() - rand.nextInt(config.xspread) + rand.nextInt(config.xspread);
            int y = pos.getY() - rand.nextInt(config.yspread) + rand.nextInt(config.yspread);
            int z = pos.getZ() - rand.nextInt(config.zspread) + rand.nextInt(config.zspread);
            movingPos.set(x, y, z);
            if (world.isAir(movingPos)) {
                boolean anyStoneAdj = false;
                Direction[] var13 = Direction.values();
                int var14 = var13.length;

                for(int var15 = 0; var15 < var14; ++var15) {
                    Direction dir = var13[var15];
                    adjPos.set(movingPos.offset(dir, 1));
                    BlockState adjState = world.getBlockState(adjPos);
                    if (adjState.isOpaqueFullCube(world, adjPos) && adjState.getMaterial() == Material.STONE) {
                        anyStoneAdj = true;
                        break;
                    }
                }

                if (anyStoneAdj) {
                    world.setBlockState(movingPos, config.blockProvider.getBlockState(rand, movingPos), 2);
                }
            }
        }

        return true;
    }
}
