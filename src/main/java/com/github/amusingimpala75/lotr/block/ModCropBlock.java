package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModCropBlock extends CropBlock {
    public Item seeds;
    public ModCropBlock(Settings settings, Item seeds) {
        super(settings);
        this.seeds = seeds;
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return this.seeds;
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.FARMLAND);
    }
}
