package com.github.amusingimpala75.lotr.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class DolAmrothBrick extends Block {
    public DolAmrothBrick(Settings settings) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(ABOVE, true));
    }
    public static final BooleanProperty ABOVE = BooleanProperty.of("above");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ABOVE);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(ABOVE, false);
    }
}
