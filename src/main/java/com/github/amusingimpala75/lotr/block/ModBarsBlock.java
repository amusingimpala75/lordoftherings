package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.state.StateManager;
/*
Simple Wrapper Class for PaneBlock
 */
public class ModBarsBlock extends PaneBlock {
    public ModBarsBlock(Settings settings) {
        super(settings);
    }

    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
    }
}
