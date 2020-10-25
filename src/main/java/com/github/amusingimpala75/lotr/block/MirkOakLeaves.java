package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class MirkOakLeaves extends Block {

    public static final BooleanProperty DOWN = BooleanProperty.of("down");

    public MirkOakLeaves(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(DOWN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(DOWN);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(DOWN, false);
    }
}
