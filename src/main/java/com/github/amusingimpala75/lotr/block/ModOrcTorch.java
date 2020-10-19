package com.github.amusingimpala75.lotr.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ModOrcTorch extends TallFlowerBlock {
    public ModOrcTorch(Settings settings) {
        super(settings);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.hashCode(pos);
    }
}
