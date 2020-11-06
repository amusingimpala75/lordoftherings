package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
/*
Class for blocks that can be placed North/South/East/West, based on CarvedPumpkin
 */
public class ModDirectionalBlock extends CarvedPumpkinBlock {
    public ModDirectionalBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canDispense(WorldView worldView, BlockPos pos) {
        return false;
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {

    }

}
