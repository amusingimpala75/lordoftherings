package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.state.StateManager;

public class ModDoorBlock extends DoorBlock {
    public ModDoorBlock(Settings settings) {
        super(settings);
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}