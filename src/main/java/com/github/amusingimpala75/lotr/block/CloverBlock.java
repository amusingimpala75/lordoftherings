package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import org.jetbrains.annotations.Nullable;

public class CloverBlock extends PlantBlock {
    public static final IntProperty CLOVERS = IntProperty.of("clovers", 1, 4);
    public CloverBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(CLOVERS, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(CLOVERS);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(CLOVERS, 1);
    }
}
